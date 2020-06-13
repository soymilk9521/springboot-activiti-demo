package com.lr.activiti.advance;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/02 11:56
 */
public class ActivitiDeleteAll {
    public static void main(String[] args) {
        // 1. 获得ProcessEngine实例
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 获得RepositoryService实例
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        // 3. 获得所有流程定义
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        // 4. 删除所有流程定义
//        for (ProcessDefinition pd: list) {
//            // 普通删除： 只删除流程定义，如果流程实例未完成则删除失败
//            repositoryService.deleteDeployment(pd.getDeploymentId());
//        }
//        HistoryService historyService = defaultProcessEngine.getHistoryService();
//        List<HistoricProcessInstance> processInstances  = historyService.createHistoricProcessInstanceQuery().list();
//        for (HistoricProcessInstance instance: processInstances) {
//            // 普通删除： 删除历史记录
//            historyService.deleteHistoricProcessInstance(instance.getId());
//        }

        // 级联删除： 删除所有包括历史记录和未完成的流程实例（全部删除）
        for (ProcessDefinition pd: list) {
            repositoryService.deleteDeployment(pd.getDeploymentId(), true);
        }

    }
}

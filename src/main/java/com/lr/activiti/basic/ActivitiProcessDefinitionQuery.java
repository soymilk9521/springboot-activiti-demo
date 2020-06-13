package com.lr.activiti.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/02 8:17
 */
public class ActivitiProcessDefinitionQuery {
    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3. 得到processDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        // 4. 设置条件，并查询流程定义
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("myProcess_1").list();
        // 5. 输出流程定义信息
        for (ProcessDefinition pd : list) {
            System.out.println(pd.getId());
            System.out.println(pd.getDeploymentId());
            System.out.println(pd.getName());
            System.out.println(pd.getResourceName());
            System.out.println(pd.getDiagramResourceName());
        }
    }
}

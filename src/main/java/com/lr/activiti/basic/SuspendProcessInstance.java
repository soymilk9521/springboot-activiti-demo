package com.lr.activiti.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/02 10:41
 */
public class SuspendProcessInstance {
    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3. 得到ProcessDefinition实例
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("myProcess_1").singleResult();
        String processId = processDefinition.getId();
        // 4. 判断当前流程定义状态
        boolean suspended = processDefinition.isSuspended();
        if (suspended) {
            // 如果是挂起状态，则激活该流程定义
            repositoryService.activateProcessDefinitionById(processId);
            System.out.println("流程定义" + processId + "被激活");
        } else {
            // 如果是激活状态，则挂起流程定义
            repositoryService.suspendProcessDefinitionById(processId);
            System.out.println("流程定义" + processId + "被挂起");
        }
    }
}

package com.lr.activiti.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/02 8:17
 */
public class ActivitiProcessDefinitionDelete {
    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3. 执行删除流程定义
        repositoryService.deleteDeployment("1");
    }
}

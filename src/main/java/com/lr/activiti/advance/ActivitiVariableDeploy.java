package com.lr.activiti.advance;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/02 17:39
 */
public class ActivitiVariableDeploy {
    public static void main(String[] args) {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday-global.bpmn")
                .addClasspathResource("diagram/holiday-global.png")
                .name("请假流程-流程变量")
                .deploy();
        System.out.println(deploy.getId());
        System.out.println(deploy.getName());
    }
}

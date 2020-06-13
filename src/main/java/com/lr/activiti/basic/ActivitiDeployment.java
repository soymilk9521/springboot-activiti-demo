package com.lr.activiti.basic;

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
 * @since 2020/05/01 21:05
 * 部署Activiti流程
 * 表分析：
 * act_re_deployment 部署信息
 * act_re_procdef   流程定义的一些信息
 * act_ge_bytearray 部署资源
 */
public class ActivitiDeployment {
    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3. 添加资源，进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday3.bpmn")
                .name("请见申请流程(listener)")
                .deploy();

        // 4. 输出部署的信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }
}

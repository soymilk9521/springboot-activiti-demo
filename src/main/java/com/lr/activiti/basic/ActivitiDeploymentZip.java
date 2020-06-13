package com.lr.activiti.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

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
public class ActivitiDeploymentZip {
    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3. 定义zip输入流
        InputStream inputStream = ActivitiDeploymentZip.class
                .getClassLoader()
                .getResourceAsStream("diagram/holiday.zip");
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        // 4. 添加资源，进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请见申请流程zip")
                .deploy();

        // 4. 输出部署的信息
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());
    }
}

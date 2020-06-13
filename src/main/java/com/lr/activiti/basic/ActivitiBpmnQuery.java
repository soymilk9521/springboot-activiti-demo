package com.lr.activiti.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * <p>
 *   需求：
 *    Activiti资源文件读取，并将资源文件保存到指定文件夹
 *   技术方案：
 *    1. Activiti的API实现
 *    2. jdbc方式读取blob类型数据
 *    3. IO流，commons-io
 * </p>
 *
 * @author KR
 * @since 2020/05/02 9:01
 */
public class ActivitiBpmnQuery {
    public static void main(String[] args) throws IOException {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3. 得到processDefinitionQuery对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        // 4. 设置条件，并查询流程定义
        ProcessDefinition pd = processDefinitionQuery.processDefinitionKey("myProcess_1").singleResult();
        System.out.println(pd.getDeploymentId());
        System.out.println(pd.getResourceName());
        System.out.println(pd.getDiagramResourceName());
        // 5. 得到资源文件
        InputStream bpmnIs = repositoryService.getResourceAsStream(pd.getDeploymentId(), pd.getResourceName());
        InputStream pngIs = repositoryService.getResourceAsStream(pd.getDeploymentId(), pd.getDiagramResourceName());
        // 6. 输出文件
        OutputStream bpmnOs = new FileOutputStream("c:/tmp/" + pd.getResourceName());
        OutputStream pngOs = new FileOutputStream("c:/tmp/" + pd.getDiagramResourceName());
        IOUtils.copy(bpmnIs, bpmnOs);
        IOUtils.copy(pngIs, pngOs);
    }
}

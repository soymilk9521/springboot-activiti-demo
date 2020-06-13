package com.lr.activiti.basic;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;

/**
 * <p>
 *  添加BusinessKey 关联业务流程
 * </p>
 *
 * @author KR
 * @since 2020/05/02 10:20
 */
public class ActivitiAddbusinessKey {
    public static void main(String[] args) {
        // 1. 得到ProcessEngine类
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到RuntimeService类
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 3. 启动流程实例
        //    第一个参数： 流程定义key， 第二个参数为businessKey
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("myProcess_1", "1003");
        // 4. 输出businessKey信息
        System.out.println(processInstance.getBusinessKey());



    }
}

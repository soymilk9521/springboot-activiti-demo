package com.lr.activiti.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * <p>
 *  启动流程实例
 * </p>
 *
 * @author KR
 * @since 2020/05/01 21:36
 * 表分析：
 *  act_hi_actinst： 历史活动
 *  act_hi_identitylink： 历史参与者
 *  act_hi_procinst： 历史流程实例
 *  act_hi_taskinst： 历史任务
 *  act_ru_execution： 当前执行
 *  act_ru_identitylink： 当前参与者
 *  act_ru_task： 当前任务
 */
public class ActivitiStartInstance {
    public static void main(String[] args) {
        // 1. 得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 3. 创建流程实例， 通过流程定义的key来创建（myProcess_1）
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1");
        // 4. 输出实例的相关信息
        System.out.println("部署ID" + processInstance.getDeploymentId());
        System.out.println("流程实例ID" + processInstance.getId());
        System.out.println("活动ID" + processInstance.getActivityId());
    }
}

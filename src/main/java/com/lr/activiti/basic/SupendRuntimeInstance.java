package com.lr.activiti.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * <p>
 *   当个流程实例挂起
 * </p>
 *
 * @author KR
 * @since 2020/05/02 11:08
 */
public class SupendRuntimeInstance {
    public static void main(String[] args) {
        // 1. 获得ProcessEngine实例
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 获得RuntimeService实例
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();
        // 3. 获得当前流程实例
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey("1002").singleResult();
        // 4. 判断当前流程实例状态
        boolean suspended = processInstance.isSuspended();
        String processId = processInstance.getId();
        if (suspended) {
            // 如果是挂起状态，则激活该流程定义
            runtimeService.activateProcessInstanceById(processId);
            System.out.println("当前流程实例" + processId + "被激活");
        } else {
            // 如果是激活状态，则挂起流程定义
            runtimeService.suspendProcessInstanceById(processId);
            System.out.println("当前流程实例" + processId + "被挂起");
        }
    }
}

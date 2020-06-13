package com.lr.activiti.advance;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/02 14:06
 */
public class ActivitiAssigneeVars {
    public static void main(String[] args) {
        // 1. 获得ProcessEngine实例
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 获得RuntimeService实例
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();
        // 3. 设置流程实例参数
        Map<String, Object> vars = new HashMap<String, Object>();
//        vars.put("applicant", "zhangsan");
//        vars.put("deptApproval", "lisi");
//        vars.put("genApproval", "wangwu");
//        User user = new User();
//        user.setApplicant("karl");
//        user.setApproval("jeff");
//        vars.put("user", user);
        // 4. 启动流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday-listener", "1030");
        System.out.println(processInstance.getBusinessKey());

    }
}

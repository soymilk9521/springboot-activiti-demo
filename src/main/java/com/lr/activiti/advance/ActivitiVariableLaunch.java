package com.lr.activiti.advance;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/02 17:44
 */
public class ActivitiVariableLaunch {
    public static void main(String[] args) {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService();
        Holiday holiday = new Holiday(1050, "karl", new Date(), new Date(), 1f, "结婚", "婚假");
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("holiday", holiday);
        runtimeService.startProcessInstanceByKey("holiday-global", holiday.getId().toString(), vars);
    }
}

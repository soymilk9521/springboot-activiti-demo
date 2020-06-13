package com.lr.activiti.basic;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;

import java.util.List;

/**
 * <p>
 * 流程历史记录查询
 * </p>
 *
 * @author KR
 * @since 2020/05/02 9:26
 */
public class HistoryActivityQuery {
    public static void main(String[] args) {
        // 1. 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到HistoryService实例
        HistoryService historyService = processEngine.getHistoryService();
        // 3. 得到H istoricActivityInstanceQuery实例,设置查询条件
        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery()
                .processInstanceId("2501").orderByHistoricActivityInstanceStartTime().asc().list();

        // 4. 展示历史实例信息
        for (HistoricActivityInstance instance: list) {
            System.out.println(instance.getId());
            System.out.println(instance.getActivityId());
            System.out.println(instance.getActivityName());
            System.out.println(instance.getAssignee());
            System.out.println("******************");
        }
    }
}

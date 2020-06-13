package com.lr.activiti.advance;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/02 18:32
 */
public class ActivitiVariableCommit {
    public static void main(String[] args) {
        // 1. 得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到TaskService
        TaskService taskService = processEngine.getTaskService();
        // 3. 根据流程定义的key，负责人来实现当前用户的任务列表查询
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday-global")
                .processInstanceBusinessKey("1050")
                .taskAssignee("wangwu")
                .singleResult();
        if (task != null) {
            taskService.complete(task.getId());
            System.out.println("task完成！");
        }
    }
}

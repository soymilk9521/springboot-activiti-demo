package com.lr.activiti.basic;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/01 21:57
 */
public class ActivitiTaskQuery {
    public static void main(String[] args) {
        // 1. 得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到TaskService
        TaskService taskService = processEngine.getTaskService();
        // 3. 根据流程定义的key，负责人来实现当前用户的任务列表查询
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("myProcess_1")
                .taskAssignee("zhangsan")
                .list();

       Task one = taskService.createTaskQuery()
                .processDefinitionKey("myProcess_1")
                .taskAssignee("lisi")
                .singleResult();

        // 4. 任务礼拜的展示
        for (Task task: list) {
            System.out.println(task.getName());
            System.out.println(task.getId());
            System.out.println(task.getOwner());
            System.out.println(task.getAssignee());
            System.out.println(task.getProcessInstanceId());
        }
    }
}

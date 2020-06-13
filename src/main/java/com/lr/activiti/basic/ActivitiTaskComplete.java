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
 * 表分析：
 * act_hi_actinst
 * act_hi_identitylink
 * act_hi_taskinst
 * act_ru_execution
 * act_ru_identitylink 当前参与者
 * act_ru_task 当前任务，处理结束后删除记录
 */
public class ActivitiTaskComplete {
    public static void main(String[] args) {
        // 1. 得到ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2. 得到TaskService
        TaskService taskService = processEngine.getTaskService();
        // 3. 根据流程定义的key，负责人来实现当前用户的任务列表查询
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("holiday-global")
                .processInstanceBusinessKey("1050")
                .taskAssignee("wangwu")
                .list();
        // 4. 完成任务
        for (Task task: list) {
            taskService.complete(task.getId());
        }
    }
/**
 * 流程结束表分析：
 * act_hi_actinst  设置完成时间
 * act_hi_actinst  设置完成时间
 * act_hi_procinst  设置完成时间
 * act_hi_taskinst  设置完成时间
 * act_ru_execution 清空
 * act_ru_identitylink 清空
 * act_ru_task 清空
 */

}


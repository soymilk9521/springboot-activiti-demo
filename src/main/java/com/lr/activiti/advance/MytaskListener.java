package com.lr.activiti.advance;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MytaskListener implements TaskListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void notify(DelegateTask delegateTask) {
		if("lisapply-id".equals(delegateTask.getTaskDefinitionKey())) {
			delegateTask.setAssignee("tom");
		}else if("lisapprove-id".equals(delegateTask.getTaskDefinitionKey())){
			delegateTask.setAssignee("green");
		}
	}

}

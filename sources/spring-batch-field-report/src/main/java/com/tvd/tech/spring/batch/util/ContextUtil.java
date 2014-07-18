package com.tvd.tech.spring.batch.util;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.item.ExecutionContext;

public abstract class ContextUtil {

	public static void setStepExecutionContextParameter(
			StepExecution stepExecution, String key, Object value) {
		getStepExecutionContext(stepExecution).put(key, value);
	}

	public static Object getStepExecutionContextParmeter(
			StepExecution stepExecution, String key) {
		return getStepExecutionContext(stepExecution).get(key);
	}

	public static ExecutionContext getStepExecutionContext(
			StepExecution stepExecution) {
		return stepExecution.getExecutionContext();
	}

}

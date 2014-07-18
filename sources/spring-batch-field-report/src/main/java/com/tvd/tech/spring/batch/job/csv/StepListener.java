package com.tvd.tech.spring.batch.job.csv;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.batch.item.ExecutionContext;

public class StepListener extends StepExecutionListenerSupport {

	private StepExecution stepExecution;

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		return null;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		this.stepExecution = stepExecution;
	}

	public StepExecution getStepExecution() {
		return stepExecution;
	}

	public ExecutionContext getExecutionContext() {
		return getStepExecution().getExecutionContext();
	}

}

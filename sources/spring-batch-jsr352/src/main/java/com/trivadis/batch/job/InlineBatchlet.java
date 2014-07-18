package com.trivadis.batch.job;

import javax.batch.api.Batchlet;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;

public class InlineBatchlet implements Batchlet {

	@Inject
	JobContext jobContext;
	
	@Inject
	StepContext stepContext;
	
	@Override
	public String process() throws Exception {
		System.out.println(jobContext);
		System.out.println(stepContext);
		return "SUCCESS";
	}

	@Override
	public void stop() throws Exception {
		
	}
}
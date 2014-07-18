package com.trivadis.batch.job;

import javax.batch.api.Batchlet;
import javax.inject.Inject;

public class SpringConfiguredBatchlet implements Batchlet {

	@Inject
	BatchService service;

	@Override
	public String process() throws Exception {
		System.out.println(service);
		return "SUCCESS";
	}

	@Override
	public void stop() throws Exception {
		
	}
}
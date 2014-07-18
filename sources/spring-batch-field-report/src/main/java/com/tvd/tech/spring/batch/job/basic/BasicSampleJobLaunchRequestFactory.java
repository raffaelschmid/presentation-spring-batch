package com.tvd.tech.spring.batch.job.basic;

import java.util.Date;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.integration.launch.JobLaunchRequest;

public class BasicSampleJobLaunchRequestFactory {

	private static final String NAME = "basic-sample-job";

	private final JobLocator jobLocator;

	public BasicSampleJobLaunchRequestFactory(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}

	public JobLaunchRequest create() throws NoSuchJobException {

		JobParameters params = new JobParametersBuilder().addDate("random", new Date()).toJobParameters();
		return new JobLaunchRequest(jobLocator.getJob(NAME), params);
	}
}

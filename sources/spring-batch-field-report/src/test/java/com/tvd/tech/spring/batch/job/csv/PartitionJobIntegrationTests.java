package com.tvd.tech.spring.batch.job.csv;

import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.tvd.tech.spring.batch.AbstractIntegrationTests;

public class PartitionJobIntegrationTests extends AbstractIntegrationTests{

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier("csv-partition-sample-job")
	private Job job;

	@Test
	public void testSimpleProperties() throws Exception {
		assertNotNull(jobLauncher);
	}

	@Test
	public void testLaunchJob() throws Exception {
		jobLauncher.run(job, new JobParametersBuilder().addLong("JUnit", (long) new Random().nextInt())
				.toJobParameters());
	}

}

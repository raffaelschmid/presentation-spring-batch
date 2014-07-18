package com.trivadis.batch.job;

import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;

import org.junit.Assert;
import org.junit.Test;

public class JobRunnerTests {

	@Test
	public void runInlineJob() {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		Properties properties = new Properties();
		Long executionId = jobOperator.start("inlineJob", properties);

		BatchStatus batchStatus = waitForJobComplete(jobOperator, executionId);
		Assert.assertTrue(BatchStatus.COMPLETED.equals(batchStatus));
	}

	@Test
	public void runBatchXmlConfigJob() {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		Properties properties = new Properties();
		Long executionId = jobOperator.start("batchXmlJob",
				properties);

		BatchStatus batchStatus = waitForJobComplete(jobOperator, executionId);
		Assert.assertTrue(BatchStatus.COMPLETED.equals(batchStatus));
	}
	@Test
	public void runSpringConfiguredJob() {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		Properties properties = new Properties();
		Long executionId = jobOperator.start("springConfiguredJobContext",
				properties);
		
		BatchStatus batchStatus = waitForJobComplete(jobOperator, executionId);
		Assert.assertTrue(BatchStatus.COMPLETED.equals(batchStatus));
	}

	private BatchStatus waitForJobComplete(JobOperator jobOperator,
			long executionId) {
		JobExecution execution = jobOperator.getJobExecution(executionId);

		BatchStatus curBatchStatus = execution.getBatchStatus();

		while (true) {
			if (curBatchStatus == BatchStatus.STOPPED
					|| curBatchStatus == BatchStatus.COMPLETED
					|| curBatchStatus == BatchStatus.FAILED) {
				break;
			}

			execution = jobOperator.getJobExecution(executionId);
			curBatchStatus = execution.getBatchStatus();
		}

		return curBatchStatus;
	}

}

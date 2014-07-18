/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tvd.tech.spring.batch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.TreeSet;

import org.junit.Test;
import org.springframework.batch.core.configuration.ListableJobLocator;
import org.springframework.beans.factory.annotation.Autowired;

public class JobConfigurationIntegrationTests extends AbstractIntegrationTests {

	@Autowired
	private ListableJobLocator jobLocator;

	@Test
	public void testSimpleProperties() throws Exception {
		assertNotNull(jobLocator);
		assertEquals("[jobCsvHeaderSample, csv-partition-sample-job, csv-performance-sample-job, basic-sample-job]", new TreeSet<String>(
				jobLocator.getJobNames()).toString());
	}

}

package com.tvd.tech.spring.batch.job.csv;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;

/**
 * Dummy {@link ItemWriter} which only logs data it receives.
 */
public class LastItemErrorWriter implements ItemWriter<Object> {

	private static final Log log = LogFactory.getLog(LastItemErrorWriter.class);

	/**
	 * @see ItemWriter#write(Object)
	 */
	@SuppressWarnings("static-access")
	@Override
	public void write(List<? extends Object> data) throws Exception {

		if (log.isInfoEnabled()) {
			log.info(String.format("Writes %d items", data.size()));
		}

		for (Object object : data) {
			Thread.currentThread().sleep(20);
			if (log.isDebugEnabled()) {
				log.debug("Write: " + object);
			}
		}

		throw new RuntimeException("Error on last item");

	}

}

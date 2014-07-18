package com.tvd.tech.spring.batch.job.csv;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.file.LineCallbackHandler;

import com.tvd.tech.spring.batch.util.ContextUtil;
import com.tvd.tech.spring.batch.util.JobParameterKeys;

public class CsvHeaderSkippedLinesCallback extends StepListener implements LineCallbackHandler {

	private static final Log log = LogFactory.getLog(CsvHeaderSkippedLinesCallback.class);

	@Override
	public void handleLine(String line) {
		if (log.isInfoEnabled()) {
			log.info("skippedLine: " + line);
		}

		Map<Integer, String> headerMap = new HashMap<Integer, String>();

		int position = 0;
		StringTokenizer st = new StringTokenizer(line, ";");
		while (st.hasMoreElements()) {
			String header = (String) st.nextElement();
			headerMap.put(position++, header);
		}

		log.info("new header: " + headerMap);

		ContextUtil.setStepExecutionContextParameter(getStepExecution(), JobParameterKeys.HEADER, headerMap);

	}
}

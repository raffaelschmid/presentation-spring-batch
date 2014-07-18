package com.tvd.tech.spring.batch.job.csv;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.tvd.tech.spring.batch.util.ContextUtil;
import com.tvd.tech.spring.batch.util.JobParameterKeys;

public class HeaderFieldSetMapper extends StepListener implements FieldSetMapper<InputLine> {

	private static final Log log = LogFactory.getLog(HeaderFieldSetMapper.class);

	@Override
	public InputLine mapFieldSet(FieldSet fieldSet) throws BindException {

		@SuppressWarnings("unchecked")
		Map<Integer, String> header = (Map<Integer, String>) ContextUtil.getStepExecutionContextParmeter(
				getStepExecution(), JobParameterKeys.HEADER);

		String[] values = fieldSet.getValues();

		Map<String, String> inputData = new HashMap<String, String>();

		for (int i = 0; i < values.length; i++) {
			inputData.put(header.get(i), values[i]);
		}

		if (log.isDebugEnabled()) {
			log.debug("new InputLine: " + inputData);
		}

		return new InputLine(inputData);
	}

}

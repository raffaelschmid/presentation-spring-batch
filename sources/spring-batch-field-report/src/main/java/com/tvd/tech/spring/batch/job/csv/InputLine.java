package com.tvd.tech.spring.batch.job.csv;

import java.util.HashMap;
import java.util.Map;

public class InputLine {

	Map<String, String> data = new HashMap<String, String>();

	public InputLine(Map<String, String> data) {
		this.data = data;
	}

	public String readString(String key) {
		return data.get(key);
	}

	@Override
	public String toString() {
		return "InputLine [data=" + data + "]";
	}

}

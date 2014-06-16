package com.jtang.sounding.domain;

import java.util.HashMap;
import java.util.Map;

import com.jtang.sounding.values.Field;
import com.jtang.sounding.values.Value;


public class Observation {
	
	private Map<Field, Value> fields;

	public Observation() {
		fields = new HashMap<Field, Value>();
	}

	public void setField(Field field, Value value) {
		fields.put(field, value);
	}
	
	public Value getFieldValue(Field field) {
		return fields.get(field);
	}

}

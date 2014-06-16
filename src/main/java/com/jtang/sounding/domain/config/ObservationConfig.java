package com.jtang.sounding.domain.config;

import java.util.ArrayList;
import java.util.List;

import com.jtang.sounding.domain.Observation;
import com.jtang.sounding.values.Field;
import com.jtang.sounding.values.Value;

// TODO: check null fields
public class ObservationConfig {

	private List<FieldConfig> fieldConfigs;

	public ObservationConfig() {
		fieldConfigs = new ArrayList<FieldConfig>();
	}
	
	public List<FieldConfig> getAllConfigs() {
		return fieldConfigs;
	}

	/*
	 * TODO: add logs to steps where return false
	 */
	public boolean validate(Observation ob) {
		
		boolean isValid = true;

		for (FieldConfig configForField : fieldConfigs) {

			Value valueForField = ob.getFieldValue(configForField.getField());
			boolean validForThisField = true;

			if (valueForField == null) {
				validForThisField = configForField.isNullable();
			} else {

				if (configForField.getUnit() != valueForField.getUnit()) {
					validForThisField = false;
				}
				if (configForField.hasLowerBound()) {
					if (valueForField.compareTo(configForField.getLowerBound()) < 0) {
						validForThisField = false;
					}
				}
				if (configForField.hasUpperBound()) {
					if (valueForField.compareTo(configForField.getUpperBound()) > 0) {
						validForThisField = false;
					}
				}
				if (configForField.hasLowerBoundField()) {
					Value valueForLowerBoundField = ob.getFieldValue(configForField.getLowerBoundField());
					if (valueForLowerBoundField == null) {
						// if lower bound field is null, then any value which is
						// bounded by the value in the lower bound field should
						// be null
						validForThisField = false;
					}
					else if (valueForField.compareTo(valueForLowerBoundField) < 0) {
						validForThisField = false;
					}
				}
				if (configForField.hasUpperBoundField()) {
					Value valueForUpperBoundField = ob.getFieldValue(configForField.getUpperBoundField());
					if (valueForUpperBoundField == null) {
						// if upper bound field is null, then any value which is
						// bounded by the value in the upper bound field should
						// be null
						validForThisField = false;
					}
					else if (valueForField.compareTo(valueForUpperBoundField) > 0) {
						validForThisField = false;
					}
				}
			}
			
			if (!validForThisField) {
				isValid = false;
			}
		}
		return isValid;
	}

	public FieldConfig getConfig(Field field) {
		for (FieldConfig config : fieldConfigs) {
			if (config.getField() == field) {
				return config;
			}
		}
		return null;
	}
	
	public void addFieldConfig(FieldConfig config) {
		fieldConfigs.add(config);
	}

}

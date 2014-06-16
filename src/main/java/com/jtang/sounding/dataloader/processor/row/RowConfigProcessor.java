package com.jtang.sounding.dataloader.processor.row;

import java.util.List;

import com.jtang.sounding.dataloader.exception.DataProcessingException;
import com.jtang.sounding.dataloader.helper.Row;
import com.jtang.sounding.dataloader.processor.ConfigProcessor;
import com.jtang.sounding.domain.config.FieldConfig;
import com.jtang.sounding.domain.config.FieldConfigDefaults;
import com.jtang.sounding.domain.config.ObservationConfig;
import com.jtang.sounding.values.Field;
import com.jtang.sounding.values.units.Unit;
import com.jtang.sounding.values.exception.FieldException;
import com.jtang.sounding.values.exception.UnitException;

public class RowConfigProcessor implements ConfigProcessor<List<Row>> {

	// TODO: check if pressure is there. That is absolutely necessary
	@Override
	public ObservationConfig process(List<Row> rows) throws DataProcessingException {

		ObservationConfig config = new ObservationConfig();

		if (rows.size() != 2) {
			throw new DataProcessingException(
					"Need two rows to process config, one for fields, one for units. Found one row instead: "
							+ rows.size());
		}
		Row fieldRow = rows.get(0);
		Row unitsRow = rows.get(1);

		if (fieldRow.size() != unitsRow.size()) {
			throw new DataProcessingException("Field rows do not match one-to-one to units.");
		}
		for (int i = 0; i < fieldRow.size(); i++) {
			try {
				String field = (String) fieldRow.get(i);
				String unit = (String) unitsRow.get(i);
				config.addFieldConfig(getFieldConfigFromString(field, unit));
			}
			catch (ClassCastException ex) {
				throw new DataProcessingException("Internal error occurred: " + ex.getMessage());
			}
		}
		return config;
	}

	private FieldConfig getFieldConfigFromString(String fieldStr, String unitStr) throws DataProcessingException {
		try {
			FieldConfig config = null;
			Field theField = Field.getField(fieldStr);
			
			switch (theField) {
			case TEMPERATURE:
				config = FieldConfigDefaults.temperature();
				break;
			case DEWPOINT:
				config = FieldConfigDefaults.dewpoint();
				break;
			case PRESSURE:
				config = FieldConfigDefaults.pressure();
				break;
			case HEIGHT:
				config = FieldConfigDefaults.height();
				break;
			case MIXING_RATIO:
				config = FieldConfigDefaults.mixingRatio();
				break;
			case WIND_DIRECTION:
				config = FieldConfigDefaults.windDirection();
				break;
			case WIND_SPEED:
				config = FieldConfigDefaults.windSpeed();
				break;
			default:
				throw new DataProcessingException("Cannot load file due to improper field: " + fieldStr);
			}
			config.setUnit(Unit.getUnit(unitStr));
			return config;

		}
		catch (UnitException ex) {
			throw new DataProcessingException("Cannot load file due to improper unit. Error message: "
					+ ex.getMessage());
		}
		catch (FieldException ex) {
			throw new DataProcessingException("Cannot load file due to improper field. Error message: "
					+ ex.getMessage());
		}
	}
}

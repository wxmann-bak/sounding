package com.jtang.sounding.dataloader.processor.row;

import java.util.List;

import com.jtang.sounding.dataloader.exception.DataProcessingException;
import com.jtang.sounding.dataloader.processor.ObservationProcessor;
import com.jtang.sounding.domain.Observation;
import com.jtang.sounding.domain.config.FieldConfig;
import com.jtang.sounding.domain.config.ObservationConfig;
import com.jtang.sounding.domain.helper.Row;
import com.jtang.sounding.values.Field;
import com.jtang.sounding.values.Value;

public class RowObservationProcessor implements ObservationProcessor<Row> {
	
	private ObservationConfig config;

	@Override
	public Observation process(Row row) throws DataProcessingException {
		if (config == null) {
			throw new DataProcessingException("No observation configuration found.");
		}
		List<FieldConfig> configs = config.getAllConfigs();
		if (row.size() != configs.size()) {
			throw new DataProcessingException("Data size is does not match number of fields");
		}
		Observation theOb = new Observation();
		for (int i = 0; i < row.size(); i++) {
			Object element = row.get(i);
			FieldConfig configForElement = configs.get(i);
			if (element instanceof Number) {
				double elementNum = ((Number)element).doubleValue();
				Field field = configForElement.getField();
				theOb.setField(field, new Value(elementNum, configForElement.getUnit()));
			}
		}
		if (!config.validate(theOb)) {
			throw new DataProcessingException("The observation is not valid, check logs for details.");
		}
		return theOb;
	}

	@Override
	public void setObservationConfig(ObservationConfig config) {
		this.config = config;
	}

}

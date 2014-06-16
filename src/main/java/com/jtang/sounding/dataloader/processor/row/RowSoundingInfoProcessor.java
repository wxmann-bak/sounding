package com.jtang.sounding.dataloader.processor.row;

import java.util.List;
import java.util.Date;

import com.jtang.sounding.dataloader.exception.DataProcessingException;
import com.jtang.sounding.dataloader.processor.SoundingInfoProcessor;
import com.jtang.sounding.domain.Sounding;
import com.jtang.sounding.domain.helper.Row;

public class RowSoundingInfoProcessor implements SoundingInfoProcessor<List<Row>> {

	@Override
	public Sounding process(List<Row> rows) throws DataProcessingException {
		Sounding sounding = new Sounding();

		if (rows.size() != 3) {
			throw new DataProcessingException("Invalid number of rows for sounding header: " + rows.size());
		}

		Row stationRow = rows.get(0);
		Row hourRow = rows.get(1);
		Row dateRow = rows.get(2);

		if (stationRow.size() != 1 || hourRow.size() != 1 || dateRow.size() != 1) {
			throw new DataProcessingException("Invalid number of columns for sounding header.");
		}

		try {
			sounding.setStation((String) stationRow.get(0));
			sounding.setHour((Integer) stationRow.get(1));
			sounding.setDate((Date) stationRow.get(2));
		}
		catch (ClassCastException ex) {
			throw new DataProcessingException("Internal error occurred. " + ex.getMessage());
		}
		return sounding;
	}

}

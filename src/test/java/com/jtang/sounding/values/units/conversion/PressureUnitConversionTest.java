package com.jtang.sounding.values.units.conversion;

import org.junit.Assert;
import org.junit.Test;

import com.jtang.sounding.values.Value;
import com.jtang.sounding.values.exception.UnitException;
import com.jtang.sounding.values.units.Unit;
import com.jtang.sounding.values.units.UnitConverter;
import com.jtang.sounding.values.utils.ValueFactory;

public class PressureUnitConversionTest {

	@Test
	public void testConvertMbToHPa() throws UnitException {
		Value p1 = ValueFactory.pressure_hPa(500);
		Value p2 = UnitConverter.convert(p1, Unit.HECTOPASCAL);
		Assert.assertTrue(p1.getValue() == p2.getValue());
	}

}

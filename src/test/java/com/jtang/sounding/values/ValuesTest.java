package com.jtang.sounding.values;

import org.junit.Assert;
import org.junit.Test;

import com.jtang.sounding.values.exception.UnitException;
import com.jtang.sounding.values.units.Unit;
import com.jtang.sounding.values.units.UnitConverter;
import com.jtang.sounding.values.utils.ValueFactory;

public class ValuesTest {

	@Test
	public void testCompareEqualButDifferentUnits() throws UnitException {
		
		Value t1 = ValueFactory.temperature_K(300);
		Value t2 = UnitConverter.convert(t1, Unit.CELSIUS);
		
		Assert.assertTrue(t1.compareTo(t2) == 0);
		Assert.assertTrue(t1.equalsAfterConversion(t2));
		Assert.assertFalse(t1.equals(t2));
	}

}

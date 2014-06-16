package com.jtang.sounding.values.units.conversion;

import org.junit.Assert;
import org.junit.Test;

import com.jtang.sounding.values.Value;
import com.jtang.sounding.values.exception.UnitException;
import com.jtang.sounding.values.units.Unit;
import com.jtang.sounding.values.units.UnitConverter;
import com.jtang.sounding.values.utils.ValueFactory;
import com.jtang.sounding.values.utils.Values;

public class TemperatureUnitConversionTest {

	@Test
	public void testConvertKelvinToKelvin() throws UnitException {
		Value temp1 = ValueFactory.temperature_K(273.15);
		Value temp2 = UnitConverter.convert(temp1, Unit.KELVIN);
		Assert.assertTrue(temp2.getValue() == temp1.getValue());
	}
	
	@Test
	public void testConvertFahrenheitToFahrenheit() throws UnitException {
		Value temp1 = ValueFactory.temperature_F(100);
		Value temp2 = UnitConverter.convert(temp1, Unit.FAHRENHEIT);
		Assert.assertTrue(temp2.getValue() == temp1.getValue());
	}
	
	@Test
	public void testConvertCelsiusToKelvin() throws UnitException {
		Value temp1 = ValueFactory.temperature_C(0);
		Value temp2 = UnitConverter.convert(temp1, Unit.KELVIN);
		Assert.assertTrue(temp2.getValue() == 273.15);
	}
	
	@Test
	public void testConvertKelvinToCelsius() throws UnitException {
		Value temp1 = Values.ABSOLUTE_ZERO;
		Value temp2 = UnitConverter.convert(temp1, Unit.CELSIUS);
		Assert.assertTrue(temp2.getValue() == -273.15);
	}
	
	@Test
	public void testConvertFahrenheitToCelsius() throws UnitException {
		Value temp1 = ValueFactory.temperature_F(32);
		Value temp2 = UnitConverter.convert(temp1, Unit.CELSIUS);
		Assert.assertTrue(temp2.getValue() == 0);
	}
	
	@Test(expected=UnitException.class)
	public void testExceptionConvertCelsiusToKnots() throws UnitException {
		Value temp1 = ValueFactory.temperature_C(32);
		UnitConverter.convert(temp1, Unit.KNOT);
	}

}

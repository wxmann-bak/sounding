package com.jtang.sounding.domain.config;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.jtang.sounding.values.Field;
import com.jtang.sounding.values.exception.UnitException;
import com.jtang.sounding.values.utils.ValueFactory;
import com.jtang.sounding.values.utils.Values;

@Ignore
public class ObservationConfigTest {

	@Test
	public void testDefaultConfig() throws UnitException {
		ObservationConfig config = new ObservationConfig();

		FieldConfig tempConfig = config.getConfig(Field.TEMPERATURE);
		Assert.assertNotNull(tempConfig);
		Assert.assertTrue(tempConfig.isNullable());
		Assert.assertTrue(tempConfig.getLowerBound().equals(Values.ABSOLUTE_ZERO));
		
		FieldConfig dewptConfig = config.getConfig(Field.DEWPOINT);
		Assert.assertNotNull(dewptConfig);
		Assert.assertTrue(dewptConfig.isNullable());
		Assert.assertTrue(dewptConfig.getLowerBound().equals(Values.ABSOLUTE_ZERO));
		Assert.assertTrue(dewptConfig.getUpperBoundField() == Field.TEMPERATURE);
		
		FieldConfig hgtConfig = config.getConfig(Field.HEIGHT);
		Assert.assertNotNull(hgtConfig);
		Assert.assertFalse(hgtConfig.isNullable());
		Assert.assertTrue(hgtConfig.getLowerBound().equals(Values.SURFACE_HGT));
		
		FieldConfig presConfig = config.getConfig(Field.PRESSURE);
		Assert.assertNotNull(presConfig);
		Assert.assertFalse(presConfig.isNullable());
		Assert.assertTrue(presConfig.getLowerBound().equals(ValueFactory.pressure_hPa(0)));
		
		FieldConfig windDirConfig = config.getConfig(Field.WIND_DIRECTION);
		Assert.assertNotNull(windDirConfig);
		Assert.assertTrue(windDirConfig.isNullable());
		Assert.assertTrue(windDirConfig.getLowerBound().equals(ValueFactory.angle_deg(0)));
		Assert.assertTrue(windDirConfig.getUpperBound().equals(ValueFactory.angle_deg(360)));
		
		FieldConfig windSpdConfig = config.getConfig(Field.WIND_SPEED);
		Assert.assertNotNull(windSpdConfig);
		Assert.assertTrue(windSpdConfig.isNullable());
		Assert.assertTrue(windSpdConfig.getLowerBound().equals(ValueFactory.speed_mps(0)));
	}

}

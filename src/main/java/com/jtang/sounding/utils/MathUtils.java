package com.jtang.sounding.utils;

public class MathUtils {
	
	private static final double DEFAULT_MAX_DISPARITY = 1E-9; 

	private MathUtils() {
	}
	
	public static boolean equalsApprox(double d1, double d2) {
		return equalsApprox(d1, d2, DEFAULT_MAX_DISPARITY);
	}

	public static boolean equalsApprox(double d1, double d2, double maxDisparity) {
		return Math.abs(d1 - d2) < maxDisparity;
	}
}

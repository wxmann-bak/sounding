package com.jtang.sounding.domain.parcel;

public class ParcelType {
	
	private String prefix;
	private int pressureRangeFromSfcInMb;
	
	ParcelType(String prefix, int pressureRangeFromSfcInMb) {
		this.prefix = prefix;
		this.pressureRangeFromSfcInMb = pressureRangeFromSfcInMb;
	}
	
	public static ParcelType surfaceBased() {
		return new ParcelType("SB", 0);
	}
	
	public static ParcelType meanLayered(int pRange) {
		return new ParcelType("ML", pRange);
	}

	public static ParcelType mostUnstable(int pRange) {
		return new ParcelType("MU", pRange);
	}

	public String getPrefix() {
		return prefix;
	}

	public int getPressureRangeFromSfcInMb() {
		return pressureRangeFromSfcInMb;
	}
}

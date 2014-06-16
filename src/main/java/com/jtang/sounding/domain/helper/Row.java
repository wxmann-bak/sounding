package com.jtang.sounding.domain.helper;

import java.util.ArrayList;
import java.util.List;

public class Row extends ArrayList<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5200114632457939312L;

	public Row(List<Object> input) {
		for (Object s: input) {
			this.add(s);
		}
	}
}

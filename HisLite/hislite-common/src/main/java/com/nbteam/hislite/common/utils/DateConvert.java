package com.nbteam.hislite.common.utils;

import org.apache.commons.beanutils.Converter;

public class DateConvert implements Converter {

	public Object convert(@SuppressWarnings("rawtypes") Class arg0, Object arg1) {
		if (arg1 == null) {
			return null;
		} else {
			return arg1;
		}
	}

}
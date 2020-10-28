package com.nbteam.hislite.common.utils;

import java.util.ArrayList;
import java.util.List;
public class ExtractCommaUtil {
	/**
	* 抽取由逗号分隔的主键列表
	*
	* @param ids
	*            由逗号分隔的多个主键值
	* @return 主键类表
	* @author wangyi2014-8-21 21:57:16
	*/
	public static List<String> extractIdListByComma(String ids) {
		List<String> result = new ArrayList<String>();
		for (String id : ids.split(",")) {
			if (id.length() > 0) {
				result.add(id.trim());
			}
		}
		return result;
	}

	public static List<Long> extractIdListToLong(String ids) {
		List<Long> result = new ArrayList<Long>();
		for (String id : ids.split(",")) {
			if (id.length() > 0) {
				try {
					result.add(Long.parseLong(id));
				} catch (Exception e) {
					return new ArrayList<Long>();
				}
			}
		}
		return result;
	}
}

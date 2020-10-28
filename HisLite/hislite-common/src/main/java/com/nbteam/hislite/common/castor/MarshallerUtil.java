package com.nbteam.hislite.common.castor;

import java.io.StringReader;
import java.net.URL;

import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.mapping.Mapping;

public class MarshallerUtil {
	/**
	 * castor orgin implements
	 */
	private Unmarshaller unmarshaller;

	public MarshallerUtil(String mappingFileNamepath, Class<?> implClass)
			throws Exception {
		Mapping mapping = new Mapping();
		URL u = new URL(implClass.getResource("").toString()
				.replaceFirst("service", "xml")
				+ mappingFileNamepath);
		mapping.loadMapping(u);
		/*
		 * mapping.loadMapping(new ClassPathResource("../xml" + File.separator +
		 * mappingFileNamepath, implClass).getURL());
		 */
		unmarshaller = new Unmarshaller(mapping);
	}

	public Object unMarshal(String xmlStr) throws Exception {
		StringReader reader = null;
		try {
			if (xmlStr.charAt(0) != '<') {
				xmlStr = xmlStr.substring(1);
			}
			reader = new StringReader(xmlStr);
			Object result = unmarshaller.unmarshal(reader);
			return result;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
}

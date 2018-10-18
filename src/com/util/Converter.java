package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Converter {
	private final static Logger log=Logger.getLogger(Converter.class);

	private static final int PAD_LIMIT=8192;
	
	private static final String[] PADDING=new String[Character.MAX_VALUE];
	
	public static String dateToStr(Date date,String fmt){
		if(null==date){
			return null;
		}
		if(null==fmt){
			return null;
		}
		SimpleDateFormat fmter=new SimpleDateFormat(fmt);
		return fmter.format(date);
	}
	
}

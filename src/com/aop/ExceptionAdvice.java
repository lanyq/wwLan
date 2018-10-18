package com.aop;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

import com.util.Converter;

public class ExceptionAdvice implements ThrowsAdvice{

	private final Logger log=Logger.getLogger(ExceptionAdvice.class);
	
	public void afterThrowing(Method method,Object[] objs,Object obj,Exception e){
		if(log.isDebugEnabled()){
			log.debug("afterThrowing..."+obj.getClass().getName());
		}
		 ByteArrayOutputStream baos=new ByteArrayOutputStream();
		 PrintStream ps=new PrintStream(baos);
		 e.printStackTrace(ps);
		 try{
			 ps.write(("\r\n"+Converter.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss")).getBytes());
		 }catch(IOException ioe){
			 ioe.printStackTrace();
		 }
	}
}

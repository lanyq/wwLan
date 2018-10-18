package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.thread.TokenThread;

@SuppressWarnings("serial")
public class InitListener implements ServletContextListener{
       /**
        * servletContext停用时调用
        */
	public void contextDestroyed(ServletContextEvent context) {
		// TODO Auto-generated method stub
		
	}
        /**
         * servlet启用时调用
         */
	public void contextInitialized(ServletContextEvent context) {
		// TODO Auto-generated method stub
		new Thread(new TokenThread()).start();
	}

}

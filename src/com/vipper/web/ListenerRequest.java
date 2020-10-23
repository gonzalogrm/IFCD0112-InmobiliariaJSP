package com.vipper.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerRequest implements ServletRequestListener {

    public ListenerRequest() {}

    public void requestDestroyed(ServletRequestEvent sre)  { 
    	
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	ServletRequest request = sre.getServletRequest();
    }
	
}

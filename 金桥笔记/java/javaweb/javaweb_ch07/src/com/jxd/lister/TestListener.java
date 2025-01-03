package com.jxd.lister;

import com.sun.xml.internal.ws.api.policy.PolicyResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class TestListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    private int num = 0;//当前服务器中session的个数
    // Public constructor is required by servlet spec
    public TestListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        num++;
        //让所有用户都能看到当前在线人数，将其存在application对象中
        ServletContext application =  se.getSession().getServletContext();
        application.setAttribute("num",num);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        num--;
        //让所有用户都能看到当前在线人数，将其存在application对象中
        ServletContext application =  se.getSession().getServletContext();
        application.setAttribute("num",num);
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}

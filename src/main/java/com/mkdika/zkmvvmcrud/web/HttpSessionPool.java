
package com.mkdika.zkmvvmcrud.web;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import org.zkoss.zk.ui.http.HttpSessionListener;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class HttpSessionPool extends HttpSessionListener {
    
    @Override
    public void sessionCreated(HttpSessionEvent evt) {        
        super.sessionCreated(evt);
        HttpSession session = evt.getSession();        
    }


    @Override
    public void sessionDestroyed(HttpSessionEvent evt) {
        super.sessionDestroyed(evt);        
        HttpSession session = evt.getSession();        
    }        
}

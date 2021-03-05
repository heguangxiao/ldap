/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import vn.htc.ldap.common.Tool;
import vn.htc.ldap.model.Account;

@WebListener
public class MyContext implements ServletContextListener, HttpSessionListener {

    private static final Map<String, HttpSession> SESSION_ONLINE = new HashMap<>();

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent evt) {
        HttpSession session = evt.getSession();
        boolean result = session.isNew();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent evt) {
        HttpSession evtSession = evt.getSession();
        synchronized (SESSION_ONLINE) {
            Collection<HttpSession> listSession = SESSION_ONLINE.values();
            if (listSession != null && listSession.size() > 0) {
                for (HttpSession oneSession : listSession) {
                    if (oneSession.getId().equals(evtSession.getId())) {
                        Account userlogin = (Account) oneSession.getAttribute(MyConfig.USER_SESSION_NAME);
                        if (userlogin != null) {
                            SESSION_ONLINE.remove(userlogin.getUsername());
                        }
                        oneSession.invalidate();
                        break;
                    }
                }
            }
            SESSION_ONLINE.notify();
        }
    }

    public static boolean checkUserOneline(String user) {
        synchronized (SESSION_ONLINE) {
            if (!Tool.checkNull(user)) {
                HttpSession userSession = SESSION_ONLINE.get(user);
                return userSession != null;
            } else {
                return false;
            }
        }
    }

    public static int getNumberOfSessions() {
        synchronized (SESSION_ONLINE) {
            return SESSION_ONLINE.size();
        }
    }

    public static void putSessionOnline(String user, HttpSession session) {
        synchronized (SESSION_ONLINE) {
            SESSION_ONLINE.put(user, session);
            SESSION_ONLINE.notify();
        }
    }

    public static void logOutSession(String user) {
        synchronized (SESSION_ONLINE) {
            try {
                HttpSession oneSession = SESSION_ONLINE.get(user);
                if (oneSession != null) {
                    SESSION_ONLINE.remove(user);
                    Account userlogin = (Account) oneSession.getAttribute(MyConfig.USER_SESSION_NAME);
                    if (userlogin != null) {
                        SESSION_ONLINE.remove(userlogin.getUsername());
                    }
                    oneSession.removeAttribute(MyConfig.USER_SESSION_NAME);
                    oneSession.invalidate();
                }
            } catch (Exception e) {
                Tool.showError("logOutSession(String user)", "MyContext", e.getMessage());
            }
            SESSION_ONLINE.notify();
        }
    }

    public static void removeSessionOnline(String user) {
        synchronized (SESSION_ONLINE) {
            SESSION_ONLINE.remove(user);
            SESSION_ONLINE.notify();
        }
    }

}

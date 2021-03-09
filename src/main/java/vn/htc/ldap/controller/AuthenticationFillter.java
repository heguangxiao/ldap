/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.htc.ldap.common.Tool;
import vn.htc.ldap.config.MyConfig;

/**
 *
 * @author Private
 */
@WebFilter(filterName = "Authentication", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR})
public class AuthenticationFillter implements Filter {

    private ServletContext context;
    String GUILoginURI = "/login";
    String GUI_SessionExpire_URI = "/sessionExpire";
    String[] SPECIAL_PATH = {GUILoginURI, GUI_SessionExpire_URI,
        "/register", "/forgot-password",
        "/resources/bootstrap", "/resources/jquery", "/resources/chart",
        "/resources/datatables", "/resources/font-awesome", "/resources/css",
        "/resources/js", "/resources/img", "/resources/controller"
    };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
        GUILoginURI = context.getContextPath() + GUILoginURI;
        GUI_SessionExpire_URI = context.getContextPath() + GUI_SessionExpire_URI;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            HttpSession session = req.getSession(false);
            boolean loggedIn = session != null && session.getAttribute(MyConfig.USER_SESSION_NAME) != null;
            if (loggedIn || isSpecialPath(req)) {
                chain.doFilter(req, resp);
            } else {
                String path = req.getRequestURI();
                if (path.endsWith("jsp")) {
                    resp.sendRedirect(GUILoginURI);
                    return;
                }
                if (path.contains("/rest/")) {
                    resp.sendRedirect(GUI_SessionExpire_URI);
                    Tool.out("--> Session Exprie...");
                } else {
                    resp.sendRedirect(GUILoginURI);
                }
            }
        } catch (IOException | ServletException ex) {
            chain.doFilter(req, resp);
            Tool.showError("doFilter(ServletRequest request, ServletResponse response, FilterChain chain)", "AuthenticationFillter", ex.getMessage());
        }
    }

    @Override
    public void destroy() {

    }

    boolean isSpecialPath(HttpServletRequest req) {
        boolean result = false;
        String path = req.getRequestURI();
        String contextPath = req.getContextPath();
        for (String one : SPECIAL_PATH) {
            if (path != null && (path.startsWith(one) || path.startsWith(contextPath + one))) {
                return true;
            }
        }
        return result;
    }
}

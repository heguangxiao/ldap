/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import vn.htc.ldap.common.Tool;

@Component
@PropertySource(value = {"classpath:application.properties"})
public class MyConfig {
        
    public static boolean running = false;
    public static String USER_SESSION_NAME = "userlogin";

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        try {

        } catch (Exception e) {
            Tool.showError("init()", "MyConfig", e.getMessage());
        }
    }
    
}

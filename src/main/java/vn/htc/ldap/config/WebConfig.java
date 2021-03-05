/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.htc.ldap.config;

import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "vn.htc.ldap.*")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"/tiles/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/fonts/**").addResourceLocations("/resources/fonts/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/scss/**").addResourceLocations("/resources/scss/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/vendors/**").addResourceLocations("/resources/vendors/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/resources/bootstrap/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.0.0/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/resources/jquery/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.5.1/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/resources/jquery-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/jquery-ui/1.12.0/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/resources/popper/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/popper.js/1.11.1/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/resources/angularjs/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/angularjs/1.8.0/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/resources/angular-ui-bootstrap/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/angular-ui-bootstrap/2.5.0/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/resources/js/**").addResourceLocations("classpath:/static/js/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/resources/img/**").addResourceLocations("classpath:/static/img/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
        registry.addResourceHandler("/resources/controller/**").addResourceLocations("classpath:/static/controller/").setCacheControl(CacheControl.maxAge(1, TimeUnit.SECONDS).cachePublic());
    }

}

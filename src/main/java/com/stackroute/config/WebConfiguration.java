package com.stackroute.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration      //Configuration class
public class WebConfiguration {
    @Bean
    ServletRegistrationBean h2servletRegistration()     //Bean creation for ServletRegistrationBean
    {
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");  //mapping
        return registrationBean;
    }
}

package dev.codes.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("WebAppInitializer is called in startup");

        // create spring application context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        // create the dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // register and configure the dispatcher servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME,dispatcherServlet);

        registration.setLoadOnStartup(1);
        registration.addMapping("/"); //overwrite the tomcat homepage



    }
}

package com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TestprojectsSpringbootOldproductsApplication.class);
    }

}

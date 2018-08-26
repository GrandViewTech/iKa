package com.gvt.ika.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.IOException;

@SpringBootApplication(scanBasePackages =
        {"com.gvt.ika"})
@PropertySource(value = "file:conf/auth.properties")
public class Application {

    final public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException
    {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(Application.class, args);
    }
}


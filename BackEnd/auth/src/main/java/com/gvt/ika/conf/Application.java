package com.gvt.ika.conf;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@EnableScheduling
@SpringBootApplication(scanBasePackages =
        {"com.gvt.ika"})
@PropertySource(value = "file:conf/iAuthorized/application.properties")
public class Application {

    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("conf/iAuthorized/log4j.properties"));
            PropertyConfigurator.configure(props);
            Properties p = new Properties(System.getProperties());
             p.put("com.mchange.v2.log.MLog", "com.mchange.v2.log.FallbackMLog");
              p.put("com.mchange.v2.log.FallbackMLog.DEFAULT_CUTOFF_LEVEL", "OFF");
        } catch (Exception exception) {
            exception.printStackTrace();

        }


    }

    final public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


}


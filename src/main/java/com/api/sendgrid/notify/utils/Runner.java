package com.api.sendgrid.notify.utils;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class Runner implements ApplicationRunner {
    private static final File TEMP_DIRECTORY = new File(System.getProperty("java.io.tmpdir"));
    @Override
    public void run(ApplicationArguments args) throws Exception {
        File logs = new File(TEMP_DIRECTORY, "logs");
        if(!logs.exists()){
            logs.mkdir();
        }
    }
}

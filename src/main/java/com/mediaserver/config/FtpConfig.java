package com.mediaserver.config;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.UserManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class FtpConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    FtpServer ftpServer(UserManager userManager) {
        FtpServerFactory ftpServerFactory = new FtpServerFactory();
        ftpServerFactory.setUserManager(userManager);
        return ftpServerFactory.createServer();
    }

    @Bean
    UserManager userManager(UserManagerFactory userManagerFactory) {
        return userManagerFactory.createUserManager();
    }

    @Bean
    PropertiesUserManagerFactory userManagerFactory() {
        PropertiesUserManagerFactory propertiesUserManagerFactory = new PropertiesUserManagerFactory();
        propertiesUserManagerFactory.setFile(new File("users.properties"));
        return propertiesUserManagerFactory;
    }
}

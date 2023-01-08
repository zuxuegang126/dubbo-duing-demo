package com.renhe.provider;

import com.renhe.api.GreetingsService;
import org.apache.dubbo.config.ApplicationConfig;
public class Application {
    private static String zookeeper=System.getProperty("zookeeper.address","127.0.0.1");

    public static void main(String[] args) {
        ServiceConfig<GreetingsService> serviceConfig=new ServiceConfig<GreetingsService>();
    }
}

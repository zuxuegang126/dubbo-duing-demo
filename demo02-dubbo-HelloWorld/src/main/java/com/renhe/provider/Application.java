package com.renhe.provider;

import com.renhe.api.GreetingsService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.util.concurrent.CountDownLatch;

public class Application {
    //
    private static String zookeeperHost=System.getProperty("zookeeper.address","127.0.0.1");
    public static void main(String[] args) throws InterruptedException {
        //创建服务 服务对应的接口类 作为泛型
        ServiceConfig<GreetingsService> serviceConfig=new ServiceConfig<GreetingsService>();
        //设置程序的名字
        serviceConfig.setApplication(new ApplicationConfig("first-dubbo-prvoider"));
        //设置注册中心 指定zookeeper的连接地址
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://"+zookeeperHost+":2181"));
        //设置提供的接口
        serviceConfig.setInterface(GreetingsService.class);
        //设置提供的接口实现类
        serviceConfig.setRef(new GreetingsServiceImpl());
        //设置完成 执行导出命令
        serviceConfig.export();

        System.out.println("dubbo server started+dubbo服务端已开启");
        //让线程处于挂起的状态 一直等待接收调用端的连接
        new CountDownLatch(1). await();
    }
}

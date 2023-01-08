package com.renhe.consumer;

import com.renhe.api.GreetingsService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;


public class Application {
    //private static String zookeeperHost = System.getProperty("zookeeper.address","127.0.0.1");

   // public static void main(String[] args) {
        private static String zookeeperHost = System.getProperty("zookeeper.address", "127.0.0.1");

        public static void main(String[] args) {



            ReferenceConfig<GreetingsService> reference = new ReferenceConfig<GreetingsService>();
            reference.setApplication(new ApplicationConfig("first-dubbo-consumer"));
            reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
            reference.setInterface(GreetingsService.class);
            GreetingsService service = reference.get();
            String message = service.sayHI("NIHAO");
            System.out.println(message);
        }
    }
//        //创建关联配置 要调用的接口作为泛型
//        ReferenceConfig<GreetingsService> referenceConfig=new ReferenceConfig<GreetingsService>();
//        //设置应用程序的名字
//        referenceConfig.setApplication(new ApplicationConfig("first-dubbo-cosumer"));
//        //设置注册中心
//        referenceConfig.setRegistry(new RegistryConfig("zookeeper://"+zookeeperHost+":2181"));
//        //设置要调用的接口
//        referenceConfig.setInterface(GreetingsService.class);
//        //获得要调用的接口
//        GreetingsService  greetingsService= referenceConfig.get();
//        //用接口调用自己的sayHI方法
//        String msg=greetingsService.sayHI("dubbo");
//        System.out.println(msg);
 //   }


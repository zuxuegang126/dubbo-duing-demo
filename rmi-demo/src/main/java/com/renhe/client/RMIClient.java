package com.renhe.client;

import com.renhe.api.HelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
    public static void main(String[] args) {
        HelloService helloService=null;
        try {
            helloService= (HelloService) Naming.lookup("rmi://127.0.0.1:9090/RMIServer");
            Object result=helloService.sayHello("你好吗");
            System.out.println("客户端收到"+result);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}

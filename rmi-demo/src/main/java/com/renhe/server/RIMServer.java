package com.renhe.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMIClientSocketFactory;


public class RIMServer {
    public static void main(String[] args) throws Exception {
        try {
            LocateRegistry .createRegistry(9090);
            HelloServiceImpl helloService=new HelloServiceImpl();
            Naming.bind("rmi://127.0.0.1:9090/RMIServer",helloService);
            System.out.println("RMIServer启动成功");

        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}

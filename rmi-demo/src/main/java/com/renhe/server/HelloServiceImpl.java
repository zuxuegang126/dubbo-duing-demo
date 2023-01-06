package com.renhe.server;


import com.renhe.api.HelloService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl   extends UnicastRemoteObject implements HelloService {


    private static final long serialVersionUID = -7467621637151913839L;

    public HelloServiceImpl() throws RemoteException {
    }

    public String sayHello(String msg) throws RemoteException {
        return"are you" +  msg;
    }
}

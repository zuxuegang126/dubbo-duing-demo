package com.renhe.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
    String sayHello(String msg) throws RemoteException;
}

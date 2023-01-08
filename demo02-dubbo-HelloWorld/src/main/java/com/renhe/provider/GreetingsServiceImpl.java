package com.renhe.provider;

import com.renhe.api.GreetingsService;


public class GreetingsServiceImpl implements GreetingsService {
    public String sayHI(String name) {
        return "Hi"+name;
    }

    public String sayHi(String dubbo) {
        return dubbo;
    }
}

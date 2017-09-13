package com.example.demo;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by jiaozhiguang on 2017/8/27.
 */
@Service(version = "1.0.0")
public class EchoServerImpl implements EchoService {

    public String echo(String str) {
        System.out.println(str);
        return str;
    }
}
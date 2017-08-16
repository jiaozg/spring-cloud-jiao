package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Created by jiaozhiguang on 2017/8/15.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}

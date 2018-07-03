package com.macroli.code.study.service.impl;

import com.macroli.code.study.service.DownStreamService;
import org.springframework.stereotype.Component;

@Component
public class DownStreamServiceImpl implements DownStreamService{

    public Integer callDownStream(Integer price){
        return price;
    }
}

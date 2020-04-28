package com.sofg.link;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShareHandle {

    public Map<String,Object> map = new ConcurrentHashMap<>();
}

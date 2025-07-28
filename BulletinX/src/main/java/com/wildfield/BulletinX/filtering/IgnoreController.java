package com.wildfield.BulletinX.filtering;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class IgnoreController {

//    @GetMapping("/filtering")
//    public TopSecret filtering(){
//        return new TopSecret("value1","value2","value3");
//    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList(){
    List<TopSecret> list = Arrays.asList(
            new TopSecret("value1", "value2", "value3"),
            new TopSecret("value4", "value5", "value6")
    );

    // 定义过滤器，过滤掉field1字段
    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("field1");
    SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("topSecretFilter", filter);

    // 用MappingJacksonValue包裹返回值，并设置过滤器
    MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);

        return mapping;
    }
}

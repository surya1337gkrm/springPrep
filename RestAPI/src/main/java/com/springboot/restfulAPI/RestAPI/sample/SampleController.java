package com.springboot.restfulAPI.RestAPI.sample;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SampleController {

    @GetMapping("/sample")
    public Sample getFilteredSamples(){
        return new Sample("Surya","Venkatesh","Vijjana");
    }

    //static filtering will be applied for lists too.

    @GetMapping("/sample-list")
    public List<Sample> getFilteredSamplesList(){
        return Arrays.asList(new Sample("Surya","Venkatesh","Vijjana"),new Sample("Madhuri","Maddy","Jangiti"));
    }

    @GetMapping("sample-dynamic")
    public MappingJacksonValue getDynamicFilteredSample(){
        Sample s = new Sample("Surya","Venkatesh","Vijjana");
        MappingJacksonValue m = new MappingJacksonValue(s);
        SimpleBeanPropertyFilter simpleBeanFilter =  SimpleBeanPropertyFilter.filterOutAllExcept("s1","s2");
        FilterProvider filter = new SimpleFilterProvider().addFilter("SampleBeanFilter",simpleBeanFilter);
        m.setFilters(filter);

        return m;
    }
}

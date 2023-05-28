package com.springboot.restfulAPI.RestAPI.sample;
//implementation of static filtering
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"s2","s3"})
//@JsonIgnoreProperties("s3") // to ignore single field

@JsonFilter("SampleBeanFilter") //add in case of dynamic filter
public class Sample {
    private String s1;
    private String s2;
    //We can filter/ignore a specific field in the response json either by adding @JsonIgnore annotation
    //on the filed we want to ignore. Or, We can add JsonIgnoreProperties annotation on the Bean class and
    //specify the properties. If there's only one property we can specify the field and if there are multiple fields
    // add the fields to ignore as an array.

//    @JsonIgnore
    private String s3;

    public Sample(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                '}';
    }
}

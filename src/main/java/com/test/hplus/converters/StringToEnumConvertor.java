package com.test.hplus.converters;

//This class change the String value from the HTML page or client side to a Gender object

import com.test.hplus.beans.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConvertor implements Converter<String, Gender> {
    @Override
    public Gender convert(String s) {
    	
        if(s.equals("Male")){
            return Gender.MALE;
        }
        else if(s.equals("Female")){
            return Gender.FEMALE;
        }
        else{
            return Gender.OTHER;
        }
    }
}


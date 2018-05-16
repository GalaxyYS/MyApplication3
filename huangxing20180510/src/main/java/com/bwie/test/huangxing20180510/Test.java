package com.bwie.test.huangxing20180510;

import android.util.Log;

import java.lang.annotation.Annotation;

/**
 * Created by Galaxy on 2018/5/10.
 */

public class Test {


    public static  void main(String [] args){
        Class<Person> personClass = Person.class;


        Entity  entity = personClass.getAnnotation(Entity.class);

       ;
        Log.i("TAG",entity.value());




    }
}

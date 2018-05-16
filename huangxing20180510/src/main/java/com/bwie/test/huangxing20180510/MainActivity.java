package com.bwie.test.huangxing20180510;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Class<Person> personClass = Person.class;


        Entity  entity = personClass.getAnnotation(Entity.class);

        ;
        Log.i("TAG",entity.value());


    }
}

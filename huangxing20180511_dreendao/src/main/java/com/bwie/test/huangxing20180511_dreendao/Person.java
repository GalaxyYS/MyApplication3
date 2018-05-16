package com.bwie.test.huangxing20180511_dreendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by Galaxy on 2018/5/11.
 */


@Entity
public class Person {

    @Id(autoincrement = true)
    private Long id;
    @Property
    private String name;
    @Generated(hash=628813901)

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

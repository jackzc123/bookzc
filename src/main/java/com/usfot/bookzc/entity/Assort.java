package com.usfot.bookzc.entity;

import javax.persistence.*;

/**
 * @author zc
 * @create 2019-05_29-22:38
 */
@Table(name = "assort")
@Entity
public class Assort {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column
    private String name;

    @Override
    public String toString() {
        return "Assort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Assort(String name) {

        this.name = name;
    }

    public Assort() {

    }
}

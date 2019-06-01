package com.usfot.bookzc.entity;

import javax.persistence.*;

/**
 * @author zc
 * @create 2019-05_29-22:40
 */
@Table(name = "author")
@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String address;
    @Column
    private Integer age;
    @Column
    private String email;
    @Column
    private Integer phone;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone=" + phone +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Author(String name, String password, String address, Integer age, String email, Integer phone) {

        this.name = name;
        this.password = password;
        this.address = address;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public Author() {

    }
}

package com.usfot.bookzc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author zc
 * @create 2019-05_29-22:44
 */
@Table(name = "book")
@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column
    private String title;
    @Column
    private String hits;
    @Column
    private String introduction;
    @Column(name = "picture_url")
    private String pictureUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column
    private Date ctime;

    @JoinColumn(name = "assort_id")
    @ManyToOne
    private Assort assort;
    @JoinColumn(name = "author_id")
    @ManyToOne
    private Author author;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", hits='" + hits + '\'' +
                ", introduction='" + introduction + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", ctime=" + ctime +
                ", assort=" + assort +
                ", author=" + author +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Assort getAssort() {
        return assort;
    }

    public void setAssort(Assort assort) {
        this.assort = assort;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(String title, String hits, String introduction, String pictureUrl, Date ctime, Assort assort, Author author) {

        this.title = title;
        this.hits = hits;
        this.introduction = introduction;
        this.pictureUrl = pictureUrl;
        this.ctime = ctime;
        this.assort = assort;
        this.author = author;
    }

    public Book() {

    }
}

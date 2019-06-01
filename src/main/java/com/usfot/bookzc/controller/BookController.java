package com.usfot.bookzc.controller;

import com.usfot.bookzc.config.HttpClientDownloader;
import com.usfot.bookzc.novelWebMagicSpider.NovelPageProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import us.codecraft.webmagic.Spider;

/**
 * @author zc
 * @create 2019-05_29-22:32
 */
@Controller
public class BookController {

    @RequestMapping("/index")
    public String index(){
        //Spider.create(new NovelPageProcessor()).setDownloader(new HttpClientDownloader()).addUrl("https://b.faloo.com/f/597242.html").thread(5).run();
        String path = this.getClass().getResource("/").getPath() + "static/pic/book/";
        System.out.println(path);
        return "index";
    }
    
    public void test1(){

    }
}

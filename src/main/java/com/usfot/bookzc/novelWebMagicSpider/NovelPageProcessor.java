package com.usfot.bookzc.novelWebMagicSpider;

import com.usfot.bookzc.entity.Assort;
import com.usfot.bookzc.entity.Author;
import com.usfot.bookzc.entity.Book;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author zc
 * @create 2019-05_26-21:04
 */
public class NovelPageProcessor implements PageProcessor {

    private Site site = Site.me()
            .setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        //page.putField("link", page.getUrl().regex("http://chuangshi.qq.com/bk/\\w+/.*").toString());
        //page.putField("title", page.getHtml().xpath("//div[@id='title']/h1/text()").toString());
        //page.putField("content", page.getHtml().xpath("//div[@id='content']/text()").toString());
        /*if (page.getResultItems().get("content")==null){
            //skip this page
            page.setSkip(true);
        }*/
        String title = page.getHtml().xpath("//div[@id='title']/h1/text()").toString();
        String hits = page.getHtml().xpath("//div[@id='title']/h1/text()").toString();
        String introduction = page.getHtml().xpath("//div[@id='title']/h1/text()").toString();
        String crtime = page.getHtml().xpath("//div[@id='title']/h1/text()").toString();
        String pictureUrl = page.getHtml().xpath("//div[@id='title']/h1/text()").toString();
        String assortName = page.getHtml().xpath("//div[@id='title']/h1/text()").toString();
        String authorName = page.getHtml().xpath("//div[@id='title']/h1/text()").toString();
        Book book = new Book();
        Assort assort = new Assort();
        Author author = new Author();
        assort.setName(assortName);
        author.setName(authorName);
        book.setAssort(assort);
        book.setAuthor(author);
        book.setTitle(title);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            book.setCtime(simpleDateFormat.parse(crtime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        book.setHits(hits);
        book.setIntroduction(introduction);
        book.setPictureUrl(pictureUrl);
        page.putField("assort", assort);
        page.putField("author", assort);
        page.putField("book", book);
        page.addTargetRequests(page.getHtml().links().regex("(https://b.faloo.com/vip/.*)").all());
    }

    @Override
    public Site getSite() {
        return site;
    }
}

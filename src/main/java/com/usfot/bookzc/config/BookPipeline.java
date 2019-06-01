package com.usfot.bookzc.config;

import com.usfot.bookzc.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author zc
 * @create 2019-05_30-23:54
 */
@Component
public class BookPipeline implements Pipeline{

    @Autowired
    private BookRepository bookRepository;


    @Override
    public void process(ResultItems resultItems, Task task) {

    }
}

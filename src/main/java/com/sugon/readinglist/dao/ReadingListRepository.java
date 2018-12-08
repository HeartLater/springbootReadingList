package com.sugon.readinglist.dao;

import com.sugon.readinglist.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: wanglei1@sugon.com
 * @created： 2018/12/8 0008 上午 10:50
 */
public interface ReadingListRepository extends JpaRepository<Book,Long>{
    List<Book> findByReader(String reader);
}

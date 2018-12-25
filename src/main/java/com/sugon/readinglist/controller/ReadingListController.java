package com.sugon.readinglist.controller;

import com.sugon.readinglist.dao.ReadingListRepository;
import com.sugon.readinglist.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: wanglei1@sugon.com
 * @created： 2018/12/8 0008 上午 10:59
 */

@Controller
@RequestMapping("/")
public class ReadingListController {


    @Autowired
    private ReadingListRepository readingListRepository;
/*    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository){
        this.readingListRepository = readingListRepository;
    }*/

    @RequestMapping(value = "/{reader}",method = RequestMethod.GET)
    public String readersBooks(@PathVariable String reader, Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books",readingList);
        }
        return "readingList";
    }
/*    @RequestMapping(value = "/{reader}",method = RequestMethod.GET)
    public String readersBooks(@PathVariable String reader){
        ModelAndView modelAndView = new ModelAndView(reader);
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            modelAndView.addObject("books",readingList);
        }
        return "readingList";
    }*/

    @RequestMapping(value = "/{reader}",method = RequestMethod.POST)
    public String addToReadingList(@PathVariable String reader,Book book){
        book.setAuthor(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}

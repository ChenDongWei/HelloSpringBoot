package com.minstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.minstone.entity.Book;
import com.minstone.service.BookService;

/**
 *  图书控制类
 * @author ChenDongWei
 *
 */
@RestController
@RequestMapping("/book/")
public class BookController {
	@Autowired
	private BookService bookService;
	
	/**
	 * 
	 * list:(查询所有图书). <br/> 
	 * @author ChenDongWei
	 * @date 2018年8月9日下午8:27:53
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("bookList");
		modelAndView.addObject("bookList", bookService.findAll());
		return modelAndView;
	}
	
	/**
	 * 
	 * add:(添加图书). <br/> 
	 * @author ChenDongWei
	 * @date 2018年8月9日下午8:28:48
	 * @param book
	 * @return
	 */
	@RequestMapping("add")
	public ModelAndView add(Book book) {
		bookService.add(book);
		return list();
	}
	
	/**
	 * 
	 * preUpdate:(跳转到修改图书). <br/> 
	 * @author ChenDongWei
	 * @date 2018年8月9日下午8:29:07
	 * @param id
	 * @return
	 */
	@RequestMapping("preUpdate/{id}")
	public ModelAndView preUpdate(@PathVariable("id")Integer id) {
		ModelAndView modelAndView = new ModelAndView("bookUpdate");
		modelAndView.addObject("book", bookService.preUpdate(id));
		return modelAndView;
	}
	
	/**
	 * 
	 * update:(修改图书). <br/> 
	 * @author ChenDongWei
	 * @date 2018年8月9日下午8:29:25
	 * @param book
	 * @return
	 */
	@RequestMapping("update")
	public ModelAndView update(Book book) {
		bookService.update(book);
		return list();
	}
	
	/**
	 * 
	 * delete:(删除图书). <br/> 
	 * @author ChenDongWei
	 * @date 2018年8月9日下午8:29:43
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	public ModelAndView delete(Integer id) {
		bookService.delete(id);
		return list();
	}
	
	/**
	 * 
	 * query:(根据名称查询图书). <br/> 
	 * @author ChenDongWei
	 * @date 2018年8月10日上午10:16:04
	 * @param bookName
	 * @return
	 */
	@RequestMapping("queryByName")
	public ModelAndView queryByName(String bookName) {
		ModelAndView modelAndView = new ModelAndView("bookList");
		modelAndView.addObject("bookList", bookService.queryByName("放弃"));
		return modelAndView;
	}
	
	/**
	 * 
	 * queryByNameOrAuthor:(根据名称或作者查询). <br/> 
	 * @author ChenDongWei
	 * @date 2018年8月10日下午1:46:57
	 * @param book
	 * @return
	 */
	@RequestMapping("queryByNameOrAuthor")
	public ModelAndView queryByNameOrAuthor(Book book) {
		ModelAndView modelAndView = new ModelAndView("bookList");
		modelAndView.addObject("bookList", bookService.queryByNameOrAuthor(book));
		return modelAndView;
	}
}

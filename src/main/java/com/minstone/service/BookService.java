package com.minstone.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.minstone.dao.BookDao;
import com.minstone.entity.Book;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao bookDao;
	
    //查询所有
    public List<Book> findAll(){
        return bookDao.findAll();
    }

    //添加图书
	public void add(Book book) {
		bookDao.save(book);
	}
	
	//根据ID查找图书
	public Book preUpdate(int id) {
		Book book = bookDao.getOne(id);
		return book;
	}
	
	//修改图书
	public void update(Book book) {
		bookDao.save(book);
	}
	
	//删除图书
	public void delete(int id) {
		bookDao.deleteById(id);
	}
	
	//根据书名查找图书
	public List<Book> queryByName(String bookName){
		return bookDao.queryByName(bookName);
	}
	
	//根据名称或作者查询(高级)
	public List<Book> queryByNameOrAuthor(Book book) {
		List<Book> bookList = bookDao.findAll(new Specification<Book>() {
			
			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (book != null) {
					if (StringUtils.isNotBlank(book.getBookName())) {
						predicate.getExpressions().add(cb.like(root.get("bookName"), "%"+book.getBookName().trim()+"%"));
					}
					if (StringUtils.isNotBlank(book.getAuthor())) {
						predicate.getExpressions().add(cb.like(root.get("author"), "%"+book.getAuthor().trim()+"%"));
					}
				}
				return predicate;
			}
		});
		
		return bookList;
	}
}

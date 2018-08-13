package com.minstone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.minstone.entity.Book;

/**
 *  图书dao
 * @author ChenDongWei
 *
 */
public interface BookDao extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book>{
	
	/**
	 * 
	 * queryByName:(根据名称查询图书). <br/> 
	 * @author ChenDongWei
	 * @date 2018年8月10日上午10:26:20
	 * @param bookName
	 * @return
	 */
	@Query(value = "select * from t_book where book_name like %?1%", nativeQuery=true)
	public List<Book> queryByName(String bookName);
}

package com.manage.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manage.library.bean.BookBean;
import com.manage.library.entity.Books;

@Repository
public interface BookRepository extends CrudRepository<Books, Integer> {
	
	@Query(value = "SELECT b.id AS id, b.title AS title, b.author AS author, b.issueDate AS issueDate, b.returnDate AS returnDate FROM book b",
			nativeQuery = true)
	public List<BookBean> getBookBean();
	
	
	@Query(value = "SELECT b.serialNo AS serialNo, b.title AS title, b.author AS author, b.issueDate AS issueDate, b.returnDate AS returnDate FROM book b WHERE b.id=?",
			nativeQuery = true)
	public BookBean getBookById();
	
	@Query(value = "SELECT b.id AS id, b.title AS title, b.author AS author, b.issueDate AS issueDate, b.returnDate AS returnDate FROM book b WHERE b.serialNo=?",
			nativeQuery = true)
	public List<Books> getBookBySerialNo();

}

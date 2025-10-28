package com.manage.library.service;

import java.util.List;

import com.manage.library.dto.BookDto;

public interface BookService {
	
	BookDto addBook(BookDto dto);
	List<BookDto> getAllBooks();
	BookDto getBookById(Integer id);
	List<BookDto> getBookBySerialNo(Integer serialNo);
	void removeBook(Integer id);

}

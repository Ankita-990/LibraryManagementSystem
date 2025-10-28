package com.manage.library.map;


import org.modelmapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manage.library.dto.BookDto;
import com.manage.library.entity.Books;

@Component
public class MapBookDto {

	@Autowired
	ModelMapper modelMapper;
	
//	Entity to DTO
	public BookDto bookToDto(Books book) {
		BookDto dto = this.modelMapper.map(book, BookDto.class);
		return dto;
	}
	
	
//	DTO to Entity
	public Books dtoToBook(BookDto dto) {
		Books book = this.modelMapper.map(dto, Books.class);
		return book;
	}
	
}

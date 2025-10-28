package com.manage.library.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.library.dto.BookDto;
import com.manage.library.map.MapBookDto;
import com.manage.library.repository.BookRepository;
import com.manage.library.service.BookService;
import com.manage.library.entity.Books;

@Service
public class BookServiceImplementation implements BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	MapBookDto bookDto;

	@Override
	public List<BookDto> getAllBooks() {
		List<Books> bookList = (List<Books>) bookRepo.findAll();
		List<BookDto> listDto = bookList.stream()
				.map(book -> bookDto.bookToDto(book))
				.collect(Collectors.toList());
		return listDto;
	}
	
	@Override
	public BookDto getBookById(Integer id) {
		Optional<Books> findBook = bookRepo.findById(id);
		Books book = findBook.get();
		return bookDto.bookToDto(book);
	}

	@Override
	public List<BookDto> getBookBySerialNo(Integer serialNo) {
		List<Books> list = bookRepo.getBookBySerialNo();
		List<BookDto> listDto = list.stream()
				.map(book -> bookDto.bookToDto(book))
				.collect(Collectors.toList());
		return listDto;
	}

	@Override
	public BookDto addBook(BookDto dto) {
		Books book = bookDto.dtoToBook(dto);
		bookRepo.save(book);
		return bookDto.bookToDto(book);
	}

	@Override
	public void removeBook(Integer id) {
		bookRepo.deleteById(id);
	}	
	

}

package springdata1.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springdata1.mvc.models.Book;
import springdata1.mvc.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/api/books")
	public List<Book> index(){
		return bookService.allBooks();
	}
	
	@RequestMapping(value="/api/books", method=RequestMethod.POST)
	public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, 
	@RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}
	
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
	@RequestMapping("/api/books/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
	@RequestMapping(value="/api/books/update", method=RequestMethod.POST)
	public Book update(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, 
	@RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages, @RequestParam(value="id") Long id) {
		Book book = bookService.findBook(id);
		book.setTitle(title);
		book.setDescription(desc);
		book.setLanguage(lang);
		book.setNumberOfPages(numOfPages);
		return bookService.updateBook(book);
		
	}
}

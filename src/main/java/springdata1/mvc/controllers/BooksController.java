package springdata1.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import springdata1.mvc.models.Book;
import springdata1.mvc.services.BookService;

@Controller
public class BooksController {
	private final BookService bookService;
	
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		System.out.println("Estás en books");
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "books/new.jsp";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		System.out.println("Estás en books, POST");
		if(result.hasErrors()) {
			return "/books/new.jsp";
		}
		else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		System.out.println("Estás en books/id");
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "books/show.jsp";
	}
	
	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		System.out.println("Estás en books/id/edit");
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "books/edit.jsp";
	}
	
	 
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
        	System.out.println("Estás en books/id, PUT, tu resultado tiene error");
            return "/books/edit.jsp";
        } else {
        	System.out.println("Estás en books/id, PUT, tu resultado no tiene error");
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
	
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	System.out.println("Estás en books/id, DELETE");
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}

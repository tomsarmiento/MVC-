package springdata1.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import springdata1.mvc.models.Book;
import springdata1.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks() { //Retorna todos los libros de la db
		return bookRepository.findAll();
	}
	
	public Book createBook(Book b) { // Crea un libro y lo guarda en la db
		return bookRepository.save(b);
	}
	
	public Book findBook(Long id) { //Retorna un libro si es que existe
		Optional<Book> optionalBook = bookRepository.findById(id); // EL "optional" significa que puede existir o no
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	public Book updateBook(Book b) {
		return bookRepository.save(b);
	}
}

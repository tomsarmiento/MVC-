package springdata1.mvc.repositories;

import java.util.List;
import springdata1.mvc.models.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll(); // Recupera todos los libros de la database
	List<Book> findByDescriptionContaining(String search); // Encuentra un libro por su descripción
	Long countByTitleContaining(String search); //Cuenta los libros con el titulo que contenga la cadena dada
	Long deleteByTitleStartingWith(String search); //borra el-los libros que comiencen con una cadena dada
	//Book save(Book b);
	void deleteById(Long id);
	
}

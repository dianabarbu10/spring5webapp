package diana.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import diana.springframework.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}

package diana.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import diana.springframework.spring5webapp.model.Author;
import diana.springframework.spring5webapp.model.Book;
import diana.springframework.spring5webapp.repositories.AuthorRepository;
import diana.springframework.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
    private BookRepository bookRepository;
    
    @Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
		
	}
    
    private void initData(){
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Wrox" );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

	
}

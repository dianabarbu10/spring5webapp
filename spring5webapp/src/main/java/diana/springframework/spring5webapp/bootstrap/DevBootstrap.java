package diana.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import diana.springframework.spring5webapp.model.Author;
import diana.springframework.spring5webapp.model.Book;
import diana.springframework.spring5webapp.model.Publisher;
import diana.springframework.spring5webapp.repositories.AuthorRepository;
import diana.springframework.spring5webapp.repositories.BookRepository;
import diana.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
    private BookRepository bookRepository;
	@Autowired
	private PublisherRepository publisherRepository;
    
    @Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
		
	}
    
    private void initData(){
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisher = new Publisher("Amazing publiser","This street");
        Book  ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(publisher);
        bookRepository.save(ddd);
       


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }

	
}

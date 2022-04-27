package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","12341234124");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Ros", "Johnsson");
        Book noEJB = new Book("J2EE Development without EJB", "23434563245436");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher penguinPublisher = new Publisher(
                "Penguin Random House UK – Embassy Gardens",
                "One Embassy Gardens\n8 Viaduct Gardens",
                "London",
                "London",
                "SW11 7BW");



        Publisher oreillyPublisher = new Publisher(
                "O’Reilly UK Ltd",
                "PO Box 722",
                "Farnham",
                "Farnham",
                "GU9 1PT"
        );
        publisherRepository.save(penguinPublisher);
        publisherRepository.save(oreillyPublisher);

        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}

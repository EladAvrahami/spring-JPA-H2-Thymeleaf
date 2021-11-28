package elad.springframework.spring5webapp.bootstrap;

import elad.springframework.spring5webapp.domainTheModel.Author;
import elad.springframework.spring5webapp.domainTheModel.Book;
import elad.springframework.spring5webapp.domainTheModel.Publisher;
import elad.springframework.spring5webapp.repositories.AuthorRepo;
import elad.springframework.spring5webapp.repositories.BookRep;
import elad.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component/*יאמר לספרינג לזהות מחלקה זאת כמנוהלת עי ApplicationContext*/
public class BootStrapData implements CommandLineRunner {/*מחפש מופעים של המחלקה על מנת להריץ אותם*/

    private  final AuthorRepo authorRepo;
    private final BookRep bookRep;
    private  final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRep bookRep, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRep = bookRep;
        this.publisherRepo = publisherRepo;
    }




    @Override
    public void run(String... args) throws Exception {

        System.out.println("started with bootstrap");

        Publisher publisher=new Publisher();
        publisher.setName("SFG PUblish");
        publisher.setCity("tel aviv");
        publisher.setState("Israel");

        publisherRepo.save(publisher);

        System.out.println("publisher count :"+publisherRepo.count());

        Author eric=new Author("Eric","Evens");
        Book ddd =new Book("Domain","1231");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepo.save(eric);
        bookRep.save(ddd);
        publisherRepo.save(publisher);

        Author rod=new Author("Rod","Jonson");
        Book noEJB =new Book("j2ee Development","39396666");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        authorRepo.save(rod);
        bookRep.save(noEJB);
        publisherRepo.save(publisher);

        System.out.println("Publisher num of books are :"+ publisher.getBooks().size());

        System.out.println("Num of books: "+bookRep.count());/*הצגה של מס הספרים באמצעות count*/
        System.out.println("mun of authors: "+authorRepo.count());


    }
}

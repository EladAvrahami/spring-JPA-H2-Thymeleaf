package elad.springframework.spring5webapp.repositories;

import elad.springframework.spring5webapp.domainTheModel.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRep extends CrudRepository<Book,Long> {
}

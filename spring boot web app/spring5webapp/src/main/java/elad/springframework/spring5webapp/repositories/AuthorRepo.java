package elad.springframework.spring5webapp.repositories;

import elad.springframework.spring5webapp.domainTheModel.Author;
import org.springframework.data.repository.CrudRepository;
/*configure two repositories for our Author and book Entities*/
public interface AuthorRepo extends CrudRepository<Author,Long> {
}

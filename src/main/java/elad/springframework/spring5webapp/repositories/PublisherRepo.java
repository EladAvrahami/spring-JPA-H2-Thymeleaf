package elad.springframework.spring5webapp.repositories;

import elad.springframework.spring5webapp.domainTheModel.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher,Long> {/*מקביל מלרשת מJpaRepository*/
}

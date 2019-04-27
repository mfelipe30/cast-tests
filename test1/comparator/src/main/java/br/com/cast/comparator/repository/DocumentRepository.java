package br.com.cast.comparator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.cast.comparator.domain.*;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long>  {
    /**
     * Find Documento by Id
     * @param id
     * @return Object
     */
    Document findById(long id);
    
}
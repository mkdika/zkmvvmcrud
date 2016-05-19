
package com.mkdika.zkmvvmcrud.repository;

import com.mkdika.zkmvvmcrud.entity.TbPerson;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public interface ServiceRepository extends CrudRepository<TbPerson, String> {
    
    public TbPerson findById(String id);
            
    public List<TbPerson> findAllByOrderByFirstnameAsc();            
    
}

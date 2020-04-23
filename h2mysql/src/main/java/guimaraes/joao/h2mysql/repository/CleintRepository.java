package guimaraes.joao.h2mysql.repository;

import guimaraes.joao.h2mysql.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleintRepository  extends CrudRepository< ClientEntity, Long> {

}

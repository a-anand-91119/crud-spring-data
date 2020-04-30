package in.notyouraveragedev.jpahibernate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.notyouraveragedev.jpahibernate.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}

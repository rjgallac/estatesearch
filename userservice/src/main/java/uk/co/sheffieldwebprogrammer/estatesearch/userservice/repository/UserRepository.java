package uk.co.sheffieldwebprogrammer.estatesearch.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.entity.UserData;

@Repository
public interface UserRepository extends CrudRepository<UserData, Long> {
}

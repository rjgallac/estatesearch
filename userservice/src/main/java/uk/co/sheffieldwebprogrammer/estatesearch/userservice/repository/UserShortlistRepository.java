package uk.co.sheffieldwebprogrammer.estatesearch.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.entity.UserShortlist;

@Repository
public interface UserShortlistRepository extends CrudRepository<UserShortlist, Long> {
}

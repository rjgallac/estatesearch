package uk.co.sheffieldwebprogrammer.estatesearch.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.entity.UserLike;

import java.util.List;

@Repository
public interface UserLikeRepository extends CrudRepository<UserLike, Long> {

    long count();

    List<UserLike> findByUserId(String userId);
}

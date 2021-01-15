package com.codedifferently.quickpoll.repository;

import com.codedifferently.quickpoll.domain.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long>{


  @Query(value="select v.* from Option o, Vote v where o.Poll_Id = ?1 and v.Option_Id= o.Option_Id", nativeQuery = true)
  Iterable<Vote> findByPoll(Long pollId);
}

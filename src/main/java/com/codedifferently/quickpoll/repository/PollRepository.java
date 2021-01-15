package com.codedifferently.quickpoll.repository;

import com.codedifferently.quickpoll.domain.Poll;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long>{

}

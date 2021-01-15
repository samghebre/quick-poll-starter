package com.codedifferently.quickpoll.repository;

import com.codedifferently.quickpoll.domain.Option;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<Option, Long> {
}

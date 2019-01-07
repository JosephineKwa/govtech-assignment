
package com.govtech.assignment;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends MongoRepository<User, String> {

	List<User> findByName(@Param("name") String name);

	@Query("{ 'salary': { $gte: ?0, $lte:?1 } }")
	List<User> findBySalaryBetweenInclusive(
			@Param("from") Double from, @Param("to") Double to);
}

package com.studies.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.studies.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	
	List<Post> findByTitleContainingIgnoreCase(String text);
		
	@Query("{'title': { $regex: ?0/pattern/,$options: 'i' }}")
	List<Post> searchTitle(String text);
}

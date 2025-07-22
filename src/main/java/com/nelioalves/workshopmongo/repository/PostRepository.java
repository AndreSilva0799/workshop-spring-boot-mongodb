package com.nelioalves.workshopmongo.repository;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // identifica que essa interface é uma repository
public interface PostRepository extends MongoRepository<Post,String> {
    // essa classe é responsavel por conseguir salvar/deletar/recuperar do banco "mongo"


    @Query("{'title': {$regex:?0, $options: 'i'}}")
    List<Post> findByTitle(String title);
    List<Post> findByTitleContainingIgnoreCase(String text);
}

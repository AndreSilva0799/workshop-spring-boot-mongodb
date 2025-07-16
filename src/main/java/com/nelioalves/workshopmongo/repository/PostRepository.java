package com.nelioalves.workshopmongo.repository;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // identifica que essa interface é uma repository
public interface PostRepository extends MongoRepository<Post,String> { // essa classe é responsavel por conseguir salvar/deletar/recuperar do banco "mongo"
}

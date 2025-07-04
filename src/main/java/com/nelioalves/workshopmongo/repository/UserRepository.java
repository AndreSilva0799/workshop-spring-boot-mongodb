package com.nelioalves.workshopmongo.repository;

import com.nelioalves.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // identifica que essa interface é uma repository
public interface UserRepository extends MongoRepository<User,String> { // essa classe é responsavel por conseguir salvar/deletar/recuperar do banco "mongo"
}

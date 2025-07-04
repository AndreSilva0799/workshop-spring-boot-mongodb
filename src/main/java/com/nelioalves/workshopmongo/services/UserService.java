package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // pra identificar que é um service
public class UserService {

    @Autowired // instancia automaticamente um objeto, nesse caso estou instanciando o UserRepository (Injeção de dependencia auto do spring)
    private UserRepository userRepository;

   // responsavel por retornar os usuarios do banco.
public List<User> findAll(){


    return userRepository.findAll(); // dentro dessa user repository já temos esse metodo que consulta o banco e retorna nossa lista
}

}

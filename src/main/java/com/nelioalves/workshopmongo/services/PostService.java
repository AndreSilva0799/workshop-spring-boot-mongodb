package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service // pra identificar que é um service
public class PostService {

    @Autowired
    // instancia automaticamente um objeto, nesse caso estou instanciando o UserRepository (Injeção de dependencia auto do spring)
    private PostRepository postRepository;


    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id)); // retorna o user ou se não tiver lança a exception personalizada
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // aqui serve para adicionar na data max as 24:00 por exemplo dia tal até 23:59
        return postRepository.fullSearch(text, minDate, maxDate);
    }



}

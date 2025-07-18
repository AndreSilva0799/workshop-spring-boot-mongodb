package com.nelioalves.workshopmongo.resources;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //identifica que a classe é um controller
@RequestMapping(value = "/posts") // caminho do endpoint
public class PostResources {

    @Autowired // instanciar um objeto automatico "o controlador acessa o serviço e o serviço acessa o repositorio"
    private PostService postService;

    @GetMapping(value= "/{id}")// agora o endpoind sera /users/id (id = um id especifico do banco)
    public ResponseEntity<Post> findById(@PathVariable String id) { // essa anotação serve para avisar o spring que o id passado no endpoint é um parametro do metodo

        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }


}

package com.nelioalves.workshopmongo.resources;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.resources.util.URL;
import com.nelioalves.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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

    @GetMapping(value= "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam (value="text", defaultValue = "") String text) {  // Request param com value é para mostrar que vai pegar o valor do campo text da url, se value não for informado por padrão será uma string vazia
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value= "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam (value="text", defaultValue = "") String text,
                                                 @RequestParam (value="minDate", defaultValue = "") String minDate,
                                                 @RequestParam (value="maxDate", defaultValue = "") String maxDate    ) {  // Request param com value é para mostrar que vai pegar o valor do campo text da url, se value não for informado por padrão será uma string vazia
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate,new Date(0L));
        Date max = URL.convertDate(maxDate,new Date());
        List<Post> list = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }

}

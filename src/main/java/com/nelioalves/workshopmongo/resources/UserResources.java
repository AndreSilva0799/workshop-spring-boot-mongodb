package com.nelioalves.workshopmongo.resources;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController //identifica que a classe é um controller
@RequestMapping(value = "/users") // caminho do endpoint
public class UserResources {

    @Autowired // instanciar um objeto automatico "o controlador acessa o serviço e o serviço acessa o repositorio"
    private UserService userService;

    @GetMapping // pra informar que esse é um endpoint rest do tipo GET
    public ResponseEntity<List<UserDTO>> findAll() { // response entity serve para retornar os cabeçalhos certinho e possiveis erros
        List<User> users = userService.findAll();// assim eu uso o meu metodo que esta na classe de serviço pra a minha lista de users no meu banco de dados atraves da repository

        List<UserDTO> listDtos = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

        for (UserDTO dto : listDtos) {
            System.out.println(dto.toString());
        }

        return ResponseEntity.ok().body(listDtos); // retornando response entity resposta ok e o corpo d aresposta é a lista de users
    }

    @GetMapping(value= "/{id}")// agora o endpoind sera /users/id (id = um id especifico do banco)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) { // essa anotação serve para avisar o spring que o id passado no endpoint é um parametro do metodo

        User user = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) { // RequestBody serve para esse endpoint aceitar o objeto
        User obj = userService.fromDTO(userDTO); // assim estou convertendo o Dto para user

        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping(value = "/{id}")// agora o endpoind sera /users/id (id = um id especifico do banco)
    public ResponseEntity<Void> deleteByid(@PathVariable String id) { // essa anotação serve para avisar o spring que o id passado no endpoint é um parametro do metodo

       userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id) { // RequestBody serve para esse endpoint aceitar o objeto
        User obj = userService.fromDTO(userDTO); // assim estou convertendo o Dto para user
        obj.setId(id);
        obj = userService.update(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.noContent().build();

    }

}

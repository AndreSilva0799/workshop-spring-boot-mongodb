package com.nelioalves.workshopmongo.resources;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        for(UserDTO dto : listDtos) {
            System.out.println(dto.toString());
        }

        return ResponseEntity.ok().body(listDtos); // retornando response entity resposta ok e o corpo d aresposta é a lista de users
    }
}

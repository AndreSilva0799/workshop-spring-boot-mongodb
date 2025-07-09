package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // pra identificar que é um service
public class UserService {

    @Autowired
    // instancia automaticamente um objeto, nesse caso estou instanciando o UserRepository (Injeção de dependencia auto do spring)
    private UserRepository userRepository;

    // responsavel por retornar os usuarios do banco.
    public List<User> findAll() {


        return userRepository.findAll(); // dentro dessa user repository já temos esse metodo que consulta o banco e retorna nossa lista
    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id)); // retorna o user ou se não tiver lança a exception personalizada
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void deleteById(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId()); // buscando no banco o obj por id
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) { // recebo os dois objetos, o que foi passado com valores alterados e o que buscamos no banco por id
        newObj.setName(obj.getName()); // alterando o objeto que buscamos pelo id com os dados do objeto recebido
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO userDTO) {
    return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail() );
    }

}

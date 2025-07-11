package com.nelioalves.workshopmongo.dto;

import com.nelioalves.workshopmongo.domain.User;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private String email;

    public UserDTO() {}

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   /* @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }*/
}

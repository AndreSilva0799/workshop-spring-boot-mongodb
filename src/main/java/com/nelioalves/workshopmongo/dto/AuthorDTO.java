package com.nelioalves.workshopmongo.dto;

import com.nelioalves.workshopmongo.domain.User;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;

    public AuthorDTO() {

    }
    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
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
}

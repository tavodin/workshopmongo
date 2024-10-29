package com.tavodin.workshopmongo.services;

import com.tavodin.workshopmongo.models.dto.UserDTO;
import com.tavodin.workshopmongo.models.entities.User;
import com.tavodin.workshopmongo.repositories.UserRepository;
import com.tavodin.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        return repository.findAll().stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(String id) {
        return repository.findById(id)
                .map(UserDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    }
}

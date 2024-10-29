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
        return new UserDTO(getEntityById(id));
    }

    public UserDTO insert(UserDTO dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);
        return new UserDTO(repository.insert(entity));
    }

    public UserDTO update(String id, UserDTO dto) {
        User entity = getEntityById(id);
        copyDtoToEntity(dto, entity);
        return new UserDTO(repository.save(entity));
    }

    private User getEntityById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    }

    private void copyDtoToEntity(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }

}

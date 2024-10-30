package com.tavodin.workshopmongo.services;

import com.tavodin.workshopmongo.models.dto.PostDTO;
import com.tavodin.workshopmongo.models.dto.UserDTO;
import com.tavodin.workshopmongo.models.entities.Post;
import com.tavodin.workshopmongo.models.entities.User;
import com.tavodin.workshopmongo.repositories.PostRepository;
import com.tavodin.workshopmongo.repositories.UserRepository;
import com.tavodin.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public PostDTO findById(String id) {
        return new PostDTO(getEntityById(id));
    }

    public List<PostDTO> findByTitle(String text) {
        return repository.searchTitle(text).stream()
                .map(PostDTO::new)
                .toList();
    }

    private Post getEntityById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    }
}

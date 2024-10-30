package com.tavodin.workshopmongo.controllers;

import com.tavodin.workshopmongo.models.dto.PostDTO;
import com.tavodin.workshopmongo.models.dto.UserDTO;
import com.tavodin.workshopmongo.services.PostService;
import com.tavodin.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> fidById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

}

package com.xd.todoapp.controllers;

import com.xd.todoapp.DTOs.ListRequestDTO;
import com.xd.todoapp.entities.Lista;
import com.xd.todoapp.services.ListsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lists")
public class ListsController {

    @Autowired
    private ListsService listsService;

    @GetMapping
    public List<Lista> allLists() {
        return listsService.allLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lista> list(@PathVariable long id) {
        Optional<Lista> list = listsService.findListById(id);

        return list.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lista createList(@RequestBody ListRequestDTO list) {
        Lista lista = new Lista();
        lista.setTitle(list.getTitle());

        return listsService.createList(lista);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<HttpStatus> deleteList(@PathVariable long id) {
        listsService.deleteListById(id);
        return new HttpEntity<>(HttpStatus.OK);
    }
}

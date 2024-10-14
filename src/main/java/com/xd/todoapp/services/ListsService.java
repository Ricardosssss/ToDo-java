package com.xd.todoapp.services;

import com.xd.todoapp.entities.Lista;
import com.xd.todoapp.repositories.ListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListsService {

    @Autowired
    private ListsRepository listsRepository;

    public List<Lista> allLists() {
        return listsRepository.findAll();
    }

    public Optional<Lista> findListById(long id) {
        return listsRepository.findById(id);
    }

    public Lista createList(Lista list) {
        return listsRepository.save(list);
    }

    public void deleteListById(long id) {
        listsRepository.deleteById(id);
    }
}

package com.xd.todoapp.repositories;

import com.xd.todoapp.entities.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListsRepository extends JpaRepository<Lista, Long> {

}

package com.todolist.todo.repositories;

import com.todolist.todo.entities.ToDo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface ToDoRepository extends CrudRepository<ToDo, Integer>{
    // Return list by status: pending, completed or in-progress
    List<ToDo> getListByStatus(String status);

    // Return list by created at date: YYYY/MM/DD
    List<ToDo> getListByCreatedAt(String createdAt);

    // Return list by completed at date: YYYY/MM/DD 
    List<ToDo> getListByCompletedAt(String completedAt);
}

package com.todolist.todo.controllers;

import com.todolist.todo.entities.ToDo;
import com.todolist.todo.repositories.ToDoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping()
public class ToDoController {
    
    private ToDoRepository todoRepository;

    public ToDoController(ToDoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    // get tasks list
    @GetMapping(path="/tasks")
    public Iterable<ToDo> getAllTasks(){
        return this.todoRepository.findAll();
    }

    // get tasks by status: pending, completed or in-progress
    @GetMapping(path="/tasks/{status}")
    public Iterable<ToDo> getTasksByStatus(@PathVariable("status") String status){
        return this.todoRepository.getListByStatus(status.toLowerCase());
    }

    // get tasks by created at date: YYYY/MM/DD
    @GetMapping(path="/createdtasks/{createdAt}")
    public Iterable<ToDo> getTasksByCreatedAt(@PathVariable("createdAt") String createdAt){
        return this.todoRepository.getListByCreatedAt(createdAt);
    }

    // get tasks by completed at date: YYYY/MM/DD
    @GetMapping(path="/completedtasks/{completedAt}")
    public Iterable<ToDo> getTasksByCompletedAt(@PathVariable("completedAt") String completedAt){
        return this.todoRepository.getListByCompletedAt(completedAt);
    }

    // get task by id
    @GetMapping(path="/task/{id}")
    public ToDo getTaskById(@PathVariable("id") Integer id){
        Optional<ToDo> taskIdOptional = this.todoRepository.findById(id);

        if(!taskIdOptional.isPresent()){
            return null;
        }

        ToDo findTask = taskIdOptional.get();
        return findTask;
    }

    // update task definitions: id, title, description, created at, completed at and status
    @PutMapping(path="/task/{id}")
    public String updateTaskById(
        @PathVariable("id") Integer id,
        @RequestBody ToDo todo){
            Optional<ToDo> taskOptional = this.todoRepository.findById(id);

            if(!taskOptional.isPresent()){
                return "Id Task Not Found!";
            }

            ToDo updateTask = taskOptional.get();

            if(updateTask!=null){
                updateTask.setId(todo.getId());
            }
            if(updateTask!=null){
                updateTask.setTitle(todo.getTitle());
            }
            if(updateTask!=null){
                updateTask.setDescription(todo.getDescription());
            }
            if(updateTask!=null){
                updateTask.setCreatedAt(todo.getCreatedAt());
            }
            if(updateTask!=null){
                updateTask.setCompletedAt(todo.getCompletedAt());
            }
            if(updateTask!=null){
                updateTask.setStatus(todo.getStatus());
            }

            ToDo updatedTask = updateTask;
            return "Task: " + updatedTask.getId() + " Title: " + updatedTask.getTitle() + " Was updated!";
    }

    // update task definition: status
    @PutMapping(path="/updatetask/{id}")
    public String updateTaskStatus(
        @PathVariable("id") Integer id,
        @RequestBody ToDo status
        ){

        Optional<ToDo> taskStatusOptional = this.todoRepository.findById(id);

        if(!taskStatusOptional.isPresent()){
            return "Task Not Found!";
        }

        ToDo updateTaskStatus = taskStatusOptional.get();
        
        if(updateTaskStatus.getStatus()!=null){
            updateTaskStatus.setStatus(status.getStatus().toLowerCase());
        }

        ToDo updatedTaskStatus = updateTaskStatus;
        return "Task Id: " + updatedTaskStatus.getId() + " Title: " + updatedTaskStatus.getTitle() + " Was updated to: " + updatedTaskStatus.getStatus();

    }

    // add new task: id, title, description, created at, completed at and status
    @PostMapping(path="/task")
    public ToDo addNewTask(@RequestBody ToDo toDo){
        ToDo newTask = this.todoRepository.save(toDo);
        return newTask;
    }

    // delete task by id
    @DeleteMapping(path="/task/{id}")
    public String deleteTask(
        @PathVariable("id") Integer id){
            Optional<ToDo> taskOptional = this.todoRepository.findById(id);

            if(!taskOptional.isPresent()){
                return null;
            }
            ToDo deleteTask = taskOptional.get();
            this.todoRepository.delete(deleteTask);
            return "Task Id: "+ deleteTask.getId() + " Title: " + deleteTask.getTitle() + " Was Deleted!";
    }

}

package com.todolist.todo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="TASKSTODO")
public class ToDo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Task title column
    @Column(name="TITLE")
    private String title;

    // Task description column
    @Column(name="DESCRIPTION")
    private String description;

    // Task created at column: DD/MM/YYYY
    @Column(name="CREATED_AT")
    private String createdAt;

    // Task completed at column: DD/MM/YYYY
    @Column(name="COMPLETED_AT")
    private String completedAt;

    // Task status column: "Pending", "Completed" or "In Progress"
    @Column(name="STATUS")
    private String status;

    /*Getter Methods
     * getId, getTitle, getDescription, getCreatedAt, getCompletedAt, getStatus
    */

    // getId
    public Integer getId(){
        return this.id;
    }

    // getTitle 
    public String getTitle(){
        return this.title;
    }

    // getDescription
    public String getDescription(){
        return this.description;
    }

    // getCreatedAt
    public String getCreatedAt(){
        return this.createdAt;
    }

    // getCompletedAt
    public String getCompletedAt(){
        return this.createdAt;
    }

    // getStatus
    public String getStatus(){
        return this.status;
    }

    /* Setter Methods
     * setId, setTitle, setDescription, setCreatedAt, setCompletedAt, setStatus
    */

    // setId
    public void setId(Integer id){
        this.id = id;
    }

    // setTitle
    public void setTitle(String title){
        this.title = title;
    }

    // setDescription
    public void setDescription(String description){
        this.description = description;
    }

    // setCreatedAt
    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    // setCompletedAt
    public void setCompletedAt(String completedAt){
        this.completedAt = completedAt;
    }
    
    // setStatus
    public void setStatus(String status){
        this.status = status;
    }
}

package com.alohatech.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alohatech.model.Task;



@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
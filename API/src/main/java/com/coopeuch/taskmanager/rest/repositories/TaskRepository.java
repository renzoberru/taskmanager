package com.coopeuch.taskmanager.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coopeuch.taskmanager.models.Tarea;

public interface TaskRepository extends JpaRepository<Tarea, Integer> {
}
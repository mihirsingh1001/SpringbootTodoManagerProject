package com.mihirsingh.todomanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mihirsingh.todomanager.models.Todo;

public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {

}

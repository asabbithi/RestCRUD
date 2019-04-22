package com.crudrestproject.crudrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudrestproject.crudrest.model.*;

@Repository("bookRepo")
public interface BookRepo extends JpaRepository<Book, Integer> {

}

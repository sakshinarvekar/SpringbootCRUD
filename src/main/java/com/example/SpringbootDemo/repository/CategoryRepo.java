package com.example.SpringbootDemo.repository;

import com.example.SpringbootDemo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository <Category, Integer> {

}

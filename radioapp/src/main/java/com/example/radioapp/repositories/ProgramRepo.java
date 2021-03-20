package com.example.radioapp.repositories;

import com.example.radioapp.entities.Category;
import com.example.radioapp.entities.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepo extends JpaRepository<Program, Long> {


}

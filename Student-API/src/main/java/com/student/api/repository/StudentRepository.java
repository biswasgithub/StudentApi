package com.student.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.api.model.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	Optional<StudentEntity> findById(int id);
}

package com.student.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.api.exception.MethodArgumentNotValidException;
import com.student.api.model.StudentEntity;
import com.student.api.service.StudentService;

@RestController
public class StudentController {

	private static Logger logger = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	private StudentService service;
	// this is the get request
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<StudentEntity>> getStudentList() throws Exception {
		List<StudentEntity> studentList = service.getStudents();
		return new ResponseEntity<List<StudentEntity>>(studentList, HttpStatus.OK);
	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<StudentEntity> getSingleStudent(@PathVariable int id) throws Exception {
		logger.info("Inside controller");
		StudentEntity se = service.getSingleStudent(id);
		return new ResponseEntity<StudentEntity>(se, HttpStatus.OK);
	}

	@PostMapping("/addStudent")
	public ResponseEntity<StudentEntity> addStudent(@Valid @RequestBody StudentEntity se) {

		StudentEntity entity = service.addStudent(se);
		return new ResponseEntity<StudentEntity>(entity, HttpStatus.OK);
	}
}

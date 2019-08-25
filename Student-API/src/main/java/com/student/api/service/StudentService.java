package com.student.api.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.api.exception.NoRecordsFoundException;
import com.student.api.exception.StudentNotFoundException;
import com.student.api.model.StudentEntity;
import com.student.api.repository.StudentRepository;

@Service
public class StudentService {
	private static Logger logger=LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	private StudentRepository repository;
	
	public List<StudentEntity> getStudents() throws NoRecordsFoundException{
		List<StudentEntity> studentList = repository.findAll();
		if(studentList.size()<1)
			throw new NoRecordsFoundException("No records found");
		return studentList;
	}
	

	public StudentEntity getSingleStudent(int id) throws Exception {
		logger.info("inside getSingleStudent() in service class");
		Optional<StudentEntity> student = repository.findById(id);
		
		if(!student.isPresent())
			throw new StudentNotFoundException("Invalid student Id "+id);	
		return student.get();
	}
	
	public StudentEntity addStudent(StudentEntity se) {
		return repository.saveAndFlush(se);
	}
}

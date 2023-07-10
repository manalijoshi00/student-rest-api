package com.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curd.entities.Student;
import com.curd.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/save")
	public ResponseEntity<String>saveStudentEntity(@RequestBody Student student) {
		Integer id = studentService.saveStudent(student);
		String message = "Student Added, id:" +id;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>>getAllStudents(){
		List<Student> student = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteStudent (@PathVariable("id")int id) {
		
		studentService.deleteStudentById(id);
		String message = "Student deleted successfully";
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student>getOneStudent(@PathVariable("id")int id){
		
		return new ResponseEntity<Student>(studentService.getOneStudent(id), HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	private ResponseEntity<String>updateStudent(@RequestBody Student student) {
		Integer id = studentService.updateStudent(student);
		String message = "Student Updated id :" +id;
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}

}

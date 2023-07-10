package com.curd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.entities.Student;
import com.curd.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository srepo;
	
	public int saveStudent(Student student) {
		Student st = srepo.save(student);
		return st.getId();
	}
	
	public List<Student> getAllStudents(){
		List<Student> student = new ArrayList<Student>();
		srepo.findAll().forEach(student1 -> student.add(student1));
		return student;
	}

	public void deleteStudentById(int id) {
		srepo.deleteById(id);
	}
	
	public Student getOneStudent(int id) {
		return srepo.findById(id).get();
	}
	
	public int updateStudent(Student student) {
		Student st = srepo.save(student);
		int id = st.getId();
		return id;
	}

}

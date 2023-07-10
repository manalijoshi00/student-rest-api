package com.curd.repository;

import org.springframework.data.repository.CrudRepository;

import com.curd.entities.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}

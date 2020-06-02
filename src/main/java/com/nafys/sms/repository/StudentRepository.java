package com.nafys.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nafys.sms.domain.Student;

/*@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "students", path = "students")*/
public interface StudentRepository extends JpaRepository<Student, Long>{

}

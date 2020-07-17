package com.nafys.sms.domain.resource;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nafys.sms.domain.Student;
import com.nafys.sms.repository.StudentRepository;

@RestController
//@RepositoryRestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/students")
	//@CrossOrigin
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student entity = studentRepository.save(student);
		// return new ResponseEntity<Student>(entity, HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(entity);
	}

	@GetMapping("/students")
	@CrossOrigin
	public ResponseEntity<Page<Student>> getAllStudents(Pageable pageable, HttpServletRequest request) {
		Page<Student> page = studentRepository.findAll(pageable);
		//getHeadersInfo(request);

        return ResponseEntity.ok().body(page);
	}

	@GetMapping("/students/{id}")
	//@CrossOrigin
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Optional<Student> student = studentRepository.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(student.get());
	}
	
	private Map<String, String> getHeadersInfo(HttpServletRequest request) {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            System.out.println(key +":"+value);
            map.put(key, value);
        }

        return map;
    }
}

package br.unifacs.webservice.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CategoryResource{
	
	@Autowired
	private CategoryRepository studentRepository;
	
	@GetMapping("/categoria")
	public List<Category> retrieveAllcategory() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/categoria/{id}")
	public Category retrieveStudent(@PathVariable long id) {
		Optional<Category> student = studentRepository.findById(id);

		if (!student.isPresent())
			throw new RuntimeException("id-" + id);

		return student.get();
	}
	
	@DeleteMapping("/categoria/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentRepository.deleteById(id);
	}
	
	@PostMapping("/categoria")
	public ResponseEntity<Object> createStudent(@RequestBody Category student) {
		Category savedStudent = studentRepository.save(student);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedStudent.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/categoria/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Category student, @PathVariable long id) {

		Optional<Category> studentOptional = studentRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		studentRepository.save(student);

		return ResponseEntity.noContent().build();
	}

}

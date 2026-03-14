package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")

public class CourseController {

	@Autowired
	CourseService service;

	@GetMapping
	public ResponseEntity<List<Course>> getAll() {

		return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCourse(@PathVariable int id) {

		Course course = service.getCourse(id);

		if (course == null)
			return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {

		return new ResponseEntity<>(service.addCourse(course), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable int id) {

		boolean deleted = service.deleteCourse(id);

		if (!deleted)
			return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<>("Course deleted", HttpStatus.OK);
	}

	@GetMapping("/search/{title}")
	public ResponseEntity<List<Course>> search(@PathVariable String title) {

		return new ResponseEntity<>(service.searchCourse(title), HttpStatus.OK);
	}
}
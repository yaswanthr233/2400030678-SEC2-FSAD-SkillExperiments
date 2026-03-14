package com.klu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.model.Course;

@Service
public class CourseService {

	List<Course> courses = new ArrayList<>();

	public List<Course> getAllCourses() {
		return courses;
	}

	public Course getCourse(int id) {

		for (Course c : courses) {

			if (c.getCourseId() == id)
				return c;
		}

		return null;
	}

	public Course addCourse(Course course) {

		courses.add(course);
		return course;
	}

	public boolean deleteCourse(int id) {

		for (Course c : courses) {

			if (c.getCourseId() == id) {
				courses.remove(c);
				return true;
			}
		}

		return false;
	}

	public List<Course> searchCourse(String title) {

		List<Course> result = new ArrayList<>();

		for (Course c : courses) {

			if (c.getTitle().toLowerCase().contains(title.toLowerCase()))
				result.add(c);
		}

		return result;
	}
}
package com.sitech.bds.jpa.controller;

import com.sitech.bds.jpa.domin.Courses;
import com.sitech.bds.jpa.mapper.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    private CoursesRepository coursesRepository;

    @GetMapping("")
    public List<Courses> getAll() {
        return coursesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courses> getOne(@PathVariable Long id) {
        Optional<Courses> courses = coursesRepository.findById(id);
        if (courses.isPresent()) {
            return ResponseEntity.ok(courses.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public Courses create(@RequestBody Courses courses) {
        return coursesRepository.save(courses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Courses> update(@PathVariable Long id, @RequestBody Courses courses) {
        Optional<Courses> coursesOptional = coursesRepository.findById(id);
        if (coursesOptional.isPresent()) {
            courses.setId(id);
            return ResponseEntity.ok(coursesRepository.save(courses));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Courses> delete(@PathVariable Long id) {
        Optional<Courses> coursesOptional = coursesRepository.findById(id);
        if (coursesOptional.isPresent()) {
            coursesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.controller;

import com.example.domin.Classes;
import com.example.mapper.ClassesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Resource
    private ClassesRepository classesRepository;

    @GetMapping("")
    public List<Classes> getAll() {
        return classesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classes> getOne(@PathVariable Long id) {
        Optional<Classes> classes = classesRepository.findById(id);
        if (classes.isPresent()) {
            return ResponseEntity.ok(classes.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public Classes create(@RequestBody Classes classes) {
        return classesRepository.save(classes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classes> update(@PathVariable Long id, @RequestBody Classes classes) {
        Optional<Classes> classesOptional = classesRepository.findById(id);
        if (classesOptional.isPresent()) {
            classes.setId(id);
            return ResponseEntity.ok(classesRepository.save(classes));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Classes> delete(@PathVariable Long id) {
        Optional<Classes> classesOptional = classesRepository.findById(id);
        if (classesOptional.isPresent()) {
            classesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
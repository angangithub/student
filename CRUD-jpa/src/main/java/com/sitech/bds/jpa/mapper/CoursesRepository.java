package com.sitech.bds.jpa.mapper;

import com.sitech.bds.jpa.domin.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
}

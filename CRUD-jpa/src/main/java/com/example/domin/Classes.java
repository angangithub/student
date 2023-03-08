package com.example.domin;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
@Table(name = "classes")
public class Classes {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int grade;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

//     Constructors, getters and setters
}

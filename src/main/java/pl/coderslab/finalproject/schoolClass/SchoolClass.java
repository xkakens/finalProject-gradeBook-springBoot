package pl.coderslab.finalproject.schoolClass;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.subject.Subject;
import pl.coderslab.finalproject.teacher.Teacher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//michał
@Entity
@Getter
@Setter
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Teacher tutor;
    @ManyToMany
    private List<Subject> subjects;
}

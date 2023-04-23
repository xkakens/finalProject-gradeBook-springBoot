package pl.coderslab.finalproject.subject;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.teacher.Teacher;

import javax.persistence.*;
import java.util.List;

//michał
@Entity
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private List<Teacher> teachers;
}

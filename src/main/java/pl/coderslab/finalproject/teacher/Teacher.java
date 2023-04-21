package pl.coderslab.finalproject.teacher;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.subject.Subject;

import javax.persistence.*;
import java.util.List;


//michał
@Entity
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany
    private List<Subject> subjects;
}

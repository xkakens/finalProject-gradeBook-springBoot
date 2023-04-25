package pl.coderslab.finalproject.subject;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.schoolClass.SchoolClass;
import pl.coderslab.finalproject.teacher.Teacher;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

//michał
@Entity
@Getter
@Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=3, max=25)
    private String name;
    @ManyToMany
    private List<Teacher> teachers;

}

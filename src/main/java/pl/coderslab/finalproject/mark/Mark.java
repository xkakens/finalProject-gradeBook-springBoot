package pl.coderslab.finalproject.mark;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.student.Student;
import pl.coderslab.finalproject.subject.Subject;

import javax.persistence.*;

//michał

@Entity
@Getter
@Setter
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int importance;
    private int value;
    private String description;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private MarkType markType;
    @ManyToOne
    private Student student;
}

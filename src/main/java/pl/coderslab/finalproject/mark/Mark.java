package pl.coderslab.finalproject.mark;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import pl.coderslab.finalproject.student.Student;
import pl.coderslab.finalproject.subject.Subject;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//michał

@Entity
@Getter
@Setter
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Min(1)
    @Max(5)
    private int importance;
    @NotNull
    @Min(1)
    @Max(6)
    private int value;
    private String description = "brak opisu";
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private MarkType markType;
    @ManyToOne
    private Student student;
}

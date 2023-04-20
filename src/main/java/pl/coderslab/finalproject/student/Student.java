package pl.coderslab.finalproject.student;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.schoolClass.SchoolClass;
import pl.coderslab.finalproject.mark.Mark;
import pl.coderslab.finalproject.parent.Parent;

import javax.persistence.*;
import java.time.LocalDate;

//michał
@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @OneToOne
    private Parent firstParent;
    @OneToOne
    private Parent secondParent;
    @ManyToOne
    private SchoolClass schoolClass;


}

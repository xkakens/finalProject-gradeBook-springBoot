package pl.coderslab.finalproject.student;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.schoolClass.SchoolClass;
import pl.coderslab.finalproject.mark.Mark;
import pl.coderslab.finalproject.parent.Parent;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

//michał
@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max=15)
    private String firstName;
    @NotNull
    @Size(min=2, max=20)
    private String lastName;
    @NotNull
    private LocalDate dateOfBirth;
    @OneToOne
    private Parent firstParent;
    @OneToOne
    private Parent secondParent;
    @ManyToOne
    private SchoolClass schoolClass;


}

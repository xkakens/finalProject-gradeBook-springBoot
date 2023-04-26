package pl.coderslab.finalproject.student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.finalproject.schoolClass.SchoolClass;
import pl.coderslab.finalproject.mark.Mark;
import pl.coderslab.finalproject.parent.Parent;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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
    private String dateOfBirth;
    @OneToOne
    private Parent firstParent;
    @OneToOne
    private Parent secondParent;
    @ManyToOne
    private SchoolClass schoolClass;


}

package pl.coderslab.finalproject.teacher;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.security.user.User;
import pl.coderslab.finalproject.subject.Subject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


//michał
@Entity
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max=15)
    private String firstName;
    @NotNull
    @Size(min=2, max=20)
    private String lastName;

    @OneToOne
    private User user;
}

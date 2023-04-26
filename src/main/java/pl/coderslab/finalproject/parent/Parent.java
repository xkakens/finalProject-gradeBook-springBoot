package pl.coderslab.finalproject.parent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//michał
@Entity
@Getter
@Setter
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max=15)
    private String firstName;
    @NotNull
    @Size(min=2, max=15)
    private String lastName;
    @NotNull
    @Size(min=7, max=11)
    private String phoneNumber;
}

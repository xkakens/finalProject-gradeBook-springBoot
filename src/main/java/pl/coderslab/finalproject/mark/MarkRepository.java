package pl.coderslab.finalproject.mark;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.student.Student;

import java.util.List;
//michał
public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> findAllByStudent(Student s);
}
package pl.coderslab.finalproject.mark;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.student.Student;
import pl.coderslab.finalproject.subject.Subject;

import java.util.List;
//michał
public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> findAllByStudent(Student s);
    List<Mark> findMarksBySubjectId(Long id);
    List<Mark> findMarksByStudentIdAndSubjectId(long id1, long id2);
    void deleteBySubjectId(long id);
    void deleteById(Long id);
}
package pl.coderslab.finalproject.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
//michał
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentsBySchoolClassId(Long id);

}
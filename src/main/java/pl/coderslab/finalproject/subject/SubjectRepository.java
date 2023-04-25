package pl.coderslab.finalproject.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findDistinctByName(String name);
    List<Subject> findSubjectsByTeachers_id(Long id);


}

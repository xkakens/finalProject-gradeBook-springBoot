package pl.coderslab.finalproject.schoolClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.teacher.Teacher;
import pl.coderslab.finalproject.subject.Subject;

import java.util.List;

//michał
@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
    List<SchoolClass> findAllByTutor(Teacher teacher);
    List<SchoolClass> findSchoolClassesBySubjects_id(Long id);
}


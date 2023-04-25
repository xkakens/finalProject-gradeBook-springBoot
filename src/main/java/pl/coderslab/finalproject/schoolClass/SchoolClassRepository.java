package pl.coderslab.finalproject.schoolClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.teacher.Teacher;

import java.util.List;

//michał
@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
    List<SchoolClass> findAllByTutor(Teacher teacher);
    List<SchoolClass> findSchoolClassBySubjectList_id(Long id);
}

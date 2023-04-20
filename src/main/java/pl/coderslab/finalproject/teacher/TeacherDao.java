package pl.coderslab.finalproject.teacher;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class TeacherDao {
    private final TeacherRepository teacherRepository;
    public TeacherDao(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public Teacher specificTeacher(Long id){
        Optional<Teacher> optTeacher = teacherRepository.findById(id);
        return optTeacher.orElse(null);
    }
    public List<Teacher> allTeachers(){
        return teacherRepository.findAll();
    }
}

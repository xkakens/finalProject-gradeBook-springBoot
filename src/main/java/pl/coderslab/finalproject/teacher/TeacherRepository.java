package pl.coderslab.finalproject.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.security.user.User;

//bartek
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findTeacherById(Long id);
    Teacher findTeacherByUser(User user);
}

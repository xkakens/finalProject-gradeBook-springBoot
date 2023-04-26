package pl.coderslab.finalproject.security.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    int countAllByUsername(String username);
    List<User> findUsersByStudents_Id(long id);
}
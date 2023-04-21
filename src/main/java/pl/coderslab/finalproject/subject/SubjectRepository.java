package pl.coderslab.finalproject.subject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findDistinctByName(String name);
}

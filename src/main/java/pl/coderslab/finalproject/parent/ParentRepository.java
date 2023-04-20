package pl.coderslab.finalproject.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
   Long countParentByPhoneNumber(String phoneNumber);
   Parent getDistinctByPhoneNumber(String phoneNumber);

}

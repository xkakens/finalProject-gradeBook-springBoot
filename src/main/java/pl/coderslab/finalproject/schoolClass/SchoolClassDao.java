package pl.coderslab.finalproject.schoolClass;

import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
//michał
@Repository
@Transactional
public class SchoolClassDao {

    private final SchoolClassRepository schoolClassRepository;

    public SchoolClassDao(SchoolClassRepository schoolClassRepository) {
        this.schoolClassRepository = schoolClassRepository;
    }
    //bartek
    public void addSchoolClass(SchoolClass schoolClass){
        schoolClassRepository.save(schoolClass);
    }
    //bartek
    public List<SchoolClass> schoolClassList() {
        return schoolClassRepository.findAll();
    }

    public SchoolClass specificClass(Long id) {
        Optional<SchoolClass> optSchool = schoolClassRepository.findById(id);
        return optSchool.orElse(null);
    }

}

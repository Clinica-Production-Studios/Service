package ro.unibuc.hello.data;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepositoryImpl implements DoctorRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<PacientEntity> findAllPacientiOfDoctor(String doctorId) {

        Query query = new Query(Criteria.where("doctor.id").is(doctorId));
        List<ProgramareEntity> programari = mongoTemplate.find(query,ProgramareEntity.class);
        List<PacientEntity> pacienti = new ArrayList<>();
        for(ProgramareEntity programare: programari)
        {
            pacienti.add(programare.getPacient());
        }

        return pacienti;
    }   
}

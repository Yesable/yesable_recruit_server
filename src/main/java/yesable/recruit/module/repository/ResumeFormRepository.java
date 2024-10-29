package yesable.recruit.module.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import yesable.recruit.module.model.ResumeForm;

import java.util.Optional;

@Repository
public interface ResumeFormRepository extends MongoRepository<ResumeForm, String> {
    Optional<ResumeForm> findByRecruitId(String recruitId);
}

package yesable.recruit.module.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import yesable.recruit.module.model.ResumeForm;

@Repository
public interface ResumeFormRepository extends MongoRepository<ResumeForm, String> {
}

package yesable.recruit.module.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import yesable.recruit.module.model.Recruit;

@Repository
public interface RecruitRepository extends MongoRepository<Recruit, String> {

}

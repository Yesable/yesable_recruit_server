package yesable.recruit.module.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import yesable.recruit.module.model.Recruit;

import java.util.Optional;

@Repository
public interface RecruitRepository extends MongoRepository<Recruit, String> {
    Optional<Recruit> findByRecruitId(String recruitId);
}

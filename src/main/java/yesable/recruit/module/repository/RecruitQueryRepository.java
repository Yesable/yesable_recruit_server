package yesable.recruit.module.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import yesable.recruit.module.model.Recruit;
import yesable.recruit.module.service.RecruitFilterRequest;

import java.util.List;

@Repository
public class RecruitQueryRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Recruit> findRecruitsByFilter(RecruitFilterRequest request) {
        Query query = new Query();

        if (!request.getEmploymentForm().isEmpty()) {
            query.addCriteria(Criteria.where("employmentForm").is(request.getEmploymentForm()));
        }
        if (!request.getDisabilityDegree().isEmpty()) {
            query.addCriteria(Criteria.where("disabilityDegree").is(request.getDisabilityDegree()));
        }
        if (!request.getScholarship().isEmpty()) {
            query.addCriteria(Criteria.where("scholarship").is(request.getScholarship()));
        }
        if (!request.getCareer().isEmpty()) {
            query.addCriteria(Criteria.where("career").is(request.getCareer()));
        }

        return mongoTemplate.find(query, Recruit.class);
    }
}

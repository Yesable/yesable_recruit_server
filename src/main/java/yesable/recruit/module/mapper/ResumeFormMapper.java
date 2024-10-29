package yesable.recruit.module.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import yesable.recruit.global.config.EntityMapper;
import yesable.recruit.module.model.ResumeForm;
import yesable.recruit.module.service.ResumeFormData;

import java.util.HashMap;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface ResumeFormMapper extends EntityMapper<ResumeFormData, ResumeForm> {
    ResumeFormMapper INSTANCE = Mappers.getMapper(ResumeFormMapper.class);

    @Override
    public default ResumeFormData toDto(ResumeForm entity) {
        if (entity == null) {
            return null;
        }

        ResumeFormData.Builder resumeFormData = ResumeFormData.newBuilder();
        resumeFormData.setGoodFit(entity.getGoodFit());

        // 질문 처리
        if (entity.getQuestions() != null) {
            Map<String, Integer> questions = entity.getQuestions();
            Map<String, Integer> mutableQuestionsMap = new HashMap<>();

            for (Map.Entry<String, Integer> entry : questions.entrySet()) {
                String question = entry.getKey();
                Integer maxLength = entry.getValue();
                mutableQuestionsMap.put(question, maxLength);
            }

            resumeFormData.putAllQuestions(mutableQuestionsMap);
        }

        return resumeFormData.build();
    }


}


package yesable.recruit.module.mapper;

import com.example.recruit.ResumeFormData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import yesable.recruit.global.config.EntityMapper;
import yesable.recruit.module.model.ResumeForm;

@Mapper(componentModel = "spring")
public interface ResumeFormMapper extends EntityMapper<ResumeFormData, ResumeForm> {
    ResumeFormMapper INSTANCE = Mappers.getMapper(ResumeFormMapper.class);

}


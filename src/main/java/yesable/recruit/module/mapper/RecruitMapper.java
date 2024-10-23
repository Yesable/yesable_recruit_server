package yesable.recruit.module.mapper;

import com.example.recruit.RecruitData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import yesable.recruit.global.config.EntityMapper;
import yesable.recruit.module.model.Recruit;

@Mapper(componentModel = "spring")
public interface RecruitMapper extends EntityMapper<RecruitData, Recruit> {
    RecruitMapper INSTANCE = Mappers.getMapper(RecruitMapper.class);

}


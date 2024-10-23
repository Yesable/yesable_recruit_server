package yesable.recruit.module.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import yesable.recruit.global.config.EntityMapper;
import yesable.recruit.module.model.Recruit;
import yesable.recruit.module.service.RecruitData;

@Mapper(componentModel = "spring")
public interface RecruitMapper extends EntityMapper<RecruitData, Recruit> {
    RecruitMapper INSTANCE = Mappers.getMapper(RecruitMapper.class);

}


package yesable.recruit.module.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

/**
 * 유저 온보딩 테이블
 */
@Data
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "RECRUIT")
public class ResumeForm {

    // 기업 인재상
    private String goodFit;

    // 지원서 문항들 (문항 제목 -> 문항 최대 글자수)
    private Map<String, Integer> questions;
}

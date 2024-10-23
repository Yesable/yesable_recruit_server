package yesable.recruit.module.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 유저 온보딩 테이블
 */
@Data
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "RECRUIT")
public class Recruit {

    // 지원 공고 ID
    private String recruitId;

    // 로고 S3 이미지
    private String logoImageUrl;

    // 월급
    private Integer salary;

    // 근무 시작 시간
    private LocalTime startTime;

    // 근무 종료 시간
    private LocalTime endTime;

    // 근무 장소
    private String workPlace;

    // 채용 형태
    private String employmentForm;

    // 장애 정도
    private String disabilityDegree;

    // 근무 유형
    private String workType;

    // 담당 업무
    private String assignedTask;

    // 복리후생
    private String welfare;

    // 모집 인원
    private Integer recruitNumber;

    // 경력
    private String career;

    // 학력
    private String scholarship;

    // 우대사항
    private String preference;

    // 기업 공고 이미지
    private String recruitImageUrl;

    // 모집 시작 기간
    private LocalDate recruitStartDate;

    // 모집 종료 기간
    private LocalDate recruitEndDate;

    // 제출 서류
    private String submission;

    // 담당자명
    private String responsibilityName;

    // 문의처
    private String contactus;

    // 이메일
    private String email;

    // 홈페이지
    private String homepage;

    // 업체명
    private String companyName;

    // 대표자명
    private String exponentName;

    // 작업 환경
    private String workEnvironment;

    // 업체 주소
    private String businessAddress;

}

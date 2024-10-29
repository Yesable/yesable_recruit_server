package yesable.recruit.module.service;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import yesable.recruit.module.mapper.RecruitMapper;
import yesable.recruit.module.mapper.ResumeFormMapper;
import yesable.recruit.module.model.Recruit;
import yesable.recruit.module.model.ResumeForm;
import yesable.recruit.module.repository.RecruitQueryRepository;
import yesable.recruit.module.repository.RecruitRepository;
import yesable.recruit.module.repository.ResumeFormRepository;

import java.util.List;
import java.util.Optional;

@GrpcService
@RequiredArgsConstructor
public class RecruitService extends RecruitServiceGrpc.RecruitServiceImplBase {

    private final RecruitRepository recruitRepository;
    private final RecruitQueryRepository recruitQueryRepository;
    private final RecruitMapper recruitMapper;
    private final ResumeFormMapper resumeFormMapper;
    private final ResumeFormRepository resumeFormRepository;

    /**
     * 채용 공고 단일 조회
     */
    @Override
    public void getRecruitDetail(GetRecruitRequest request, StreamObserver<RecruitResponse> responseObserver) {
        String recruitId = request.getRecruitId();

        Optional<Recruit> recruitOptional = recruitRepository.findByRecruitId(recruitId);
        if (recruitOptional.isPresent()) {
            RecruitData recruitData = recruitMapper.toDto(recruitOptional.get());
            RecruitResponse response = RecruitResponse.newBuilder()
                    .setRecruit(recruitData)
                    .build();
            responseObserver.onNext(response);
        } else {
            responseObserver.onError(new IllegalArgumentException("Recruit not found"));
        }
        responseObserver.onCompleted();
    }


    /**
     * 필터링 기능 추가
     */
    @Override
    public void getRecruitsByFilter(RecruitFilterRequest request, StreamObserver<RecruitListResponse> responseObserver) {
        List<Recruit> recruits = recruitQueryRepository.findRecruitsByFilter(request);

        List<RecruitData> protoRecruits = recruitMapper.toDto(recruits);

        RecruitListResponse response = RecruitListResponse.newBuilder()
                .addAllRecruits(protoRecruits)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * 이력서 양식 조회
     */
    @Override
    public void getResumeForm(GetResumeFormRequest request, StreamObserver<ResumeFormResponse> responseObserver) {
        String recruitId = request.getRecruitId();

        Optional<ResumeForm> resumeFormOptional = resumeFormRepository.findByRecruitId(recruitId);
        if (resumeFormOptional.isPresent()) {
            ResumeFormResponse response = ResumeFormResponse.newBuilder()
                    .setResumeForm(resumeFormMapper.toDto(resumeFormOptional.get()))
                    .build();
            responseObserver.onNext(response);
        } else {
            responseObserver.onError(new IllegalArgumentException("Resume form not found"));
        }
        responseObserver.onCompleted();
    }
}
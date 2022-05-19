package com.example.DynamicProgrammingCoders.service;

import com.example.DynamicProgrammingCoders.dto.reponse.MessageResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.SubmissionRequestDTO;
import com.example.DynamicProgrammingCoders.model.Problem;
import com.example.DynamicProgrammingCoders.model.Submission;
import com.example.DynamicProgrammingCoders.model.User;
import com.example.DynamicProgrammingCoders.repository.IProblemRepository;
import com.example.DynamicProgrammingCoders.repository.ISubmissionRepository;
import com.example.DynamicProgrammingCoders.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService implements ISubmissionService{
    private ModelMapper mapper;
    private final ISubmissionRepository submissionRepository;
    private final IUserRepository userRepository;
    private final IProblemRepository problemRepository;
    public SubmissionService(ISubmissionRepository submissionRepository,IUserRepository userRepository,IProblemRepository problemRepository){
        this.submissionRepository = submissionRepository;
        this.userRepository = userRepository;
        this.problemRepository = problemRepository;
        mapper = new ModelMapper();
    }
    @Override
    public MessageResponseDTO createSubmission(SubmissionRequestDTO newSubmission) {
        Submission submission = mapper.map(newSubmission,Submission.class);
        Problem problem = problemRepository.findById(newSubmission.getProblemId()).orElse(null);
        User user = userRepository.findUserByUserName(newSubmission.getUserName()).orElse(null);
        submission.setProblemId(problem);
        submission.setUserName(user);
        submissionRepository.save(submission);
        return new MessageResponseDTO("Successful operation");
    }
}

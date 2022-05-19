package com.example.DynamicProgrammingCoders.service;

import com.example.DynamicProgrammingCoders.dto.reponse.MessageResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.SubmissionRequestDTO;

public interface ISubmissionService {
    MessageResponseDTO createSubmission(SubmissionRequestDTO newSubmission);
}

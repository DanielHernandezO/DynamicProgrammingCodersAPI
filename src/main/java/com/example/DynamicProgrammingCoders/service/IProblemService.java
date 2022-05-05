package com.example.DynamicProgrammingCoders.service;

import com.example.DynamicProgrammingCoders.dto.ProblemDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.ListResponseDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.MessageResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;
import org.springframework.data.jpa.repository.Query;

public interface IProblemService {
    ProblemDTO getProblemById(ParamRequestDTO param);
    ListResponseDTO getUserProblemsSolved(ParamRequestDTO userId);
    MessageResponseDTO postNewProblem(ProblemDTO problem);
    MessageResponseDTO putProblem(ParamRequestDTO problemId,ProblemDTO problem);
    MessageResponseDTO deleteProblemById(ParamRequestDTO problemId);
    ListResponseDTO getProblems();
}

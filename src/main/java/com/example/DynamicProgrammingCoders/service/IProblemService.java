package com.example.DynamicProgrammingCoders.service;

import com.example.DynamicProgrammingCoders.dto.ProblemDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.ListResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;
import org.springframework.data.jpa.repository.Query;

public interface IProblemService {
    ProblemDTO getProblemById(ParamRequestDTO param);
    ListResponseDTO getUserProblemsSolved(ParamRequestDTO userId);
}

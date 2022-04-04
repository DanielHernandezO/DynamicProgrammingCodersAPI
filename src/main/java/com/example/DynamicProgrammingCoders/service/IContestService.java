package com.example.DynamicProgrammingCoders.service;

import com.example.DynamicProgrammingCoders.dto.reponse.ListResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;

public interface IContestService {
    ListResponseDTO getUserContest(ParamRequestDTO idUser);
}

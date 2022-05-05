package com.example.DynamicProgrammingCoders.service;

import com.example.DynamicProgrammingCoders.dto.ContestInformationDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.ListResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;
import com.example.DynamicProgrammingCoders.model.Contest;
import com.example.DynamicProgrammingCoders.repository.IContestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContestService implements IContestService{
    private final IContestRepository contestRepository;
    private ModelMapper mapper = new ModelMapper();
    public ContestService(IContestRepository contestRepository){
        this.contestRepository = contestRepository;
    }
    @Override
    public ListResponseDTO getUserContest(ParamRequestDTO idUser) {
        ListResponseDTO responseDTO = new ListResponseDTO();
        List<Contest> contests = contestRepository.findAllByContestId(idUser.getParam().toString());
        responseDTO.setList(getContestInformationListDTO(contests));
        return responseDTO;
    }

    private List<ContestInformationDTO> getContestInformationListDTO(List<Contest> list){
        List<ContestInformationDTO> responseList = list.stream()
                .map(contest -> mapper.map(contest.getContestId(),ContestInformationDTO.class))
                .collect(Collectors.toList());
        return responseList;
    }
}

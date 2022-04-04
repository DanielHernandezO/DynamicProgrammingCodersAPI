package com.example.DynamicProgrammingCoders.service;

import com.example.DynamicProgrammingCoders.dto.ProblemDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.ListResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;
import com.example.DynamicProgrammingCoders.model.Problem;
import com.example.DynamicProgrammingCoders.repository.IProblemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProblemService implements IProblemService{
    private final IProblemRepository problemRepository;
    private ModelMapper mapper = new ModelMapper();
    public ProblemService(IProblemRepository problemRepository){
        this.problemRepository = problemRepository;
    }
    @Override
    public ProblemDTO getProblemById(ParamRequestDTO param) {
        Optional<Problem> problem = problemRepository.findById((Integer)param.getParam());
        if(problem.isEmpty())throw new RuntimeException("Problem does not exist");
        return mapper.map(problem.get(),ProblemDTO.class);
    }

    @Override
    public ListResponseDTO getUserProblemsSolved(ParamRequestDTO userId) {
        ListResponseDTO dto = new ListResponseDTO();
        Set<Problem> problemsSolved = problemRepository.getProblemsSolvedByAnUser((Integer)userId.getParam());
        List<ProblemDTO> problemsResponse = getListDTO(problemsSolved);
        dto.setList(problemsResponse);
        return dto;
    }

    private List<ProblemDTO> getListDTO(Set<Problem> problems){
        return problems.stream().map(x->mapper.map(x,ProblemDTO.class)).collect(Collectors.toList());
    }
}

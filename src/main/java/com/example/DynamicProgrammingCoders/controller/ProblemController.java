package com.example.DynamicProgrammingCoders.controller;

import com.example.DynamicProgrammingCoders.dto.ProblemDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.ListResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;
import com.example.DynamicProgrammingCoders.service.IProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProblemController {
    private final IProblemService problemService;
    public ProblemController(IProblemService problemService){
        this.problemService= problemService;
    }
    @GetMapping("/problem/{problemId}")
    public ResponseEntity<ProblemDTO> getProblemById(@PathVariable Integer problemId){
        ProblemDTO dto = problemService.getProblemById(new ParamRequestDTO(problemId));
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }
    @GetMapping("/problems/solved/{userId}")
    public ResponseEntity<ListResponseDTO> getUserProblemsSolved(@PathVariable Integer userId){
        ListResponseDTO dto = problemService.getUserProblemsSolved(new ParamRequestDTO(userId));
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }
}

package com.example.DynamicProgrammingCoders.controller;

import com.example.DynamicProgrammingCoders.dto.ProblemDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.ListResponseDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.MessageResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;
import com.example.DynamicProgrammingCoders.service.IProblemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProblemController {
    private final IProblemService problemService;
    public ProblemController(IProblemService problemService){
        this.problemService= problemService;
    }
    @GetMapping("/problem/all")
    public ResponseEntity<ListResponseDTO> getProblems(){
        ListResponseDTO dto = problemService.getProblems();
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }
    @GetMapping("/problem/{problemId}")
    public ResponseEntity<ProblemDTO> getProblemById(@PathVariable Integer problemId){
        ProblemDTO dto = problemService.getProblemById(new ParamRequestDTO(problemId));
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }
    @GetMapping("/problem/solved/{userId}")
    public ResponseEntity<ListResponseDTO> getUserProblemsSolved(@PathVariable Integer userId){
        ListResponseDTO dto = problemService.getUserProblemsSolved(new ParamRequestDTO(userId));
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }

    @PostMapping("/problem/new")
    public ResponseEntity<MessageResponseDTO> postNewProblem(@RequestBody ProblemDTO problem){
        MessageResponseDTO dto = problemService.postNewProblem(problem);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }
    @PutMapping("/problem/update/{problemId}")
    public ResponseEntity<MessageResponseDTO> putProblem(@RequestBody ProblemDTO problem,@PathVariable Integer problemId){
        MessageResponseDTO dto = problemService.putProblem(new ParamRequestDTO(problemId),problem);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @DeleteMapping("/problem/delete/{problemId}")
    public ResponseEntity<MessageResponseDTO> deleteProblemById(@PathVariable Integer problemId){
        MessageResponseDTO dto = problemService.deleteProblemById(new ParamRequestDTO(problemId));
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }
}

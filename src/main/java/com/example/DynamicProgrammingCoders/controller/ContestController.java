package com.example.DynamicProgrammingCoders.controller;

import com.example.DynamicProgrammingCoders.dto.reponse.ListResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;
import com.example.DynamicProgrammingCoders.service.IContestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContestController {
    private final IContestService contestService;
    public ContestController(IContestService contestService){
        this.contestService = contestService;
    }
    @GetMapping("/user/cotests/{idUser}")
    public ResponseEntity<ListResponseDTO> getUserContest(@PathVariable Integer idUser){
        ListResponseDTO dto = contestService.getUserContest(new ParamRequestDTO(idUser));
        return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
    }
}

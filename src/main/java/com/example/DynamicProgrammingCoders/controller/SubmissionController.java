package com.example.DynamicProgrammingCoders.controller;

import com.example.DynamicProgrammingCoders.dto.reponse.MessageResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.SubmissionRequestDTO;
import com.example.DynamicProgrammingCoders.service.ISubmissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SubmissionController {
    private final ISubmissionService submissionService;

    public SubmissionController(ISubmissionService submissionService){
        this.submissionService = submissionService;
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/submission/create")
    public ResponseEntity createSubmission(@RequestBody SubmissionRequestDTO newSubmission){
        MessageResponseDTO dto = submissionService.createSubmission(newSubmission);
        return new ResponseEntity(dto, HttpStatus.OK);
    }
}

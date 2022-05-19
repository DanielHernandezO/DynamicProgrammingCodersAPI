package com.example.DynamicProgrammingCoders.dto.request;

import com.example.DynamicProgrammingCoders.dto.ProblemDTO;
import com.example.DynamicProgrammingCoders.dto.UserDTO;
import com.example.DynamicProgrammingCoders.model.Problem;
import com.example.DynamicProgrammingCoders.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SubmissionRequestDTO implements Serializable {
    private Integer id;
    private Integer status;
    private String userName;
    private Integer problemId;
}

package com.example.DynamicProgrammingCoders.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
@Table(name = "problems")
public class Problem {
    @Id
    private Integer problemId;
    private Double executionTime;
    private Integer memoryLimit;
    private String title;
    @OneToMany(mappedBy = "problemId")
    private List<ProblemCategory> problemCategories;
    @OneToMany(mappedBy = "problemId")
    private List<WroteProblem> wroteProblems;
    @OneToMany(mappedBy = "problemId")
    private List<ProblemSet> problems;
    @OneToMany(mappedBy = "problemId")
    private List<Submission> submissions;
}

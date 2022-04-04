package com.example.DynamicProgrammingCoders.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
@Table(name = "submissions")
public class Submission {
    @Id
    private Integer id;
    private Integer status;
    private Integer tries;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne
    @JoinColumn(name="contest_id")
    private ContestInformation contestId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "problem_id")
    private Problem problemId;
}

package com.example.DynamicProgrammingCoders.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String name;
    private String LastName;
    private String email;
    private String password;
    private String salt;
    @CreatedDate
    private Date createdAt;
    @OneToMany(mappedBy = "userName")
    List<WroteProblem> wroteProblems;
    @OneToMany(mappedBy = "userName")
    private List<Submission> userId;
    @OneToMany(mappedBy = "userName")
    private List<Contest> contests;
}

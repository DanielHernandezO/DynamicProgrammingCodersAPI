package com.example.DynamicProgrammingCoders.controller;

import com.example.DynamicProgrammingCoders.dto.UserDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.MessageResponseDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.PasswordResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;
import com.example.DynamicProgrammingCoders.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final IUserService userService;
    public UserController(IUserService userService){
        this.userService=userService;
    }
    @GetMapping("/user/checkPassword/{userName}")
    public ResponseEntity checkPassword(@PathVariable String userName){
        PasswordResponseDTO dto = userService.checkPassword(new ParamRequestDTO(userName));
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }
    @PostMapping("/user/create")
    public ResponseEntity createUser(@RequestBody UserDTO user){
        MessageResponseDTO dto = userService.createUser(user);
        return new ResponseEntity(dto,HttpStatus.CREATED);
    }
    @GetMapping("/user/getbyid/{userName}")
    public ResponseEntity getUserById(@PathVariable String userName){
        UserDTO dto = userService.getUserById(new ParamRequestDTO(userName));
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }
}

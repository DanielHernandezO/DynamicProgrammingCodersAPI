package com.example.DynamicProgrammingCoders.service;

import com.example.DynamicProgrammingCoders.dto.UserDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.MessageResponseDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.PasswordResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;

public interface IUserService {
    PasswordResponseDTO checkPassword(ParamRequestDTO userName);
    MessageResponseDTO createUser(UserDTO user);
    UserDTO getUserById(ParamRequestDTO userName);
}

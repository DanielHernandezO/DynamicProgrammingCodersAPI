package com.example.DynamicProgrammingCoders.service;

import com.example.DynamicProgrammingCoders.dto.UserDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.MessageResponseDTO;
import com.example.DynamicProgrammingCoders.dto.reponse.PasswordResponseDTO;
import com.example.DynamicProgrammingCoders.dto.request.ParamRequestDTO;
import com.example.DynamicProgrammingCoders.exception.UserAlreadyExist;
import com.example.DynamicProgrammingCoders.exception.UserDoesntExist;
import com.example.DynamicProgrammingCoders.model.User;
import com.example.DynamicProgrammingCoders.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    private final IUserRepository userRepository;
    private ModelMapper mapper;
    public UserService(IUserRepository userRepository){
        this.userRepository=userRepository;
        this.mapper = new ModelMapper();
    }
    @Override
    public PasswordResponseDTO checkPassword(ParamRequestDTO userName) {
        User user = checkUserExistence(userName.getParam().toString());
        return new PasswordResponseDTO(user.getPassword());
    }

    @Override
    public MessageResponseDTO createUser(UserDTO user) {
        List<User> users = userRepository.findAll();
        boolean flag =false;
        for(User user1: users){
            if(user1.getUserName()!= null && user1.getUserName().equalsIgnoreCase(user.getUserName()))flag = true;
        }
        if(flag) throw new UserAlreadyExist("The user already exist");
        User newUser = mapper.map(user,User.class);
        userRepository.save(newUser);
        return new MessageResponseDTO("Successful operation");
    }

    @Override
    public UserDTO getUserById(ParamRequestDTO userName) {
        User user = checkUserExistence(userName.getParam().toString());
        UserDTO dto = mapper.map(user,UserDTO.class);
        return dto;
    }

    private User checkUserExistence(String userName){
        Optional<User> user = userRepository.findUserByUserName(userName);
        if(user.isEmpty()) throw new UserDoesntExist("The user doesn't exist");
        return user.get();
    }
}

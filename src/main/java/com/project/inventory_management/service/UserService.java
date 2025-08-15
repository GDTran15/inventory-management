package com.project.inventory_management.service;

import com.project.inventory_management.dto.CreateAccountRequestDTO;
import com.project.inventory_management.dto.LoginDTORequest;
import com.project.inventory_management.dto.LoginDTOResponse;
import com.project.inventory_management.exception.EmailAlreadyExistedException;
import com.project.inventory_management.exception.UsernameAlreadyExistException;
import com.project.inventory_management.model.Role;
import com.project.inventory_management.model.User;
import com.project.inventory_management.repository.UserRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Transactional
    public void createUser(@Valid CreateAccountRequestDTO createAccountRequestDTO) {
        System.out.println("here");
            boolean emailExist = userRepo.existsByEmail(createAccountRequestDTO.email());
            boolean userNameExist = userRepo.existsByUsername(createAccountRequestDTO.username());
            if (userNameExist){
                System.out.println("username eixts");
                throw new UsernameAlreadyExistException();
            }
            if (emailExist){
                throw new EmailAlreadyExistedException();
            }
            User user = User.builder()
                    .username(createAccountRequestDTO.username())
                    .email(createAccountRequestDTO.email())
                    .password(bCryptPasswordEncoder.encode(createAccountRequestDTO.password()))
                    .phone(createAccountRequestDTO.phone())
                    .role(createAccountRequestDTO.role())
                    .build();
            userRepo.save(user);

    }

    public LoginDTOResponse loginUser(@Valid LoginDTORequest loginDTORequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTORequest.username(), loginDTORequest.password()));
        if(authentication.isAuthenticated()){
            User user = userRepo.findByUsername(loginDTORequest.username());
          Long userId = user.getUserId();
          String token = jwtService.generateToken(user);
          return new LoginDTOResponse(userId,token);
        }
         return null;
        }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }
}

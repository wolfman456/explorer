package com.example.explorer.user.UserService.UserServiceImpl;

import com.example.explorer.exception.InformationNotFoundException;
import com.example.explorer.user.User_model.Role;
import com.example.explorer.user.User_model.UserModel;
import com.example.explorer.user.UserService.AuthService;
import com.example.explorer.user.user_repo.RoleRepository;
import com.example.explorer.user.user_repo.UserRepository;
import com.example.explorer.exception.InformationExistException;
import com.example.explorer.security.JwtTokenProvider;
import com.example.explorer.security.dto.LoginDto;
import com.example.explorer.security.dto.RegisterDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;


    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUserNameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenProvider.generateToken(authentication);
    }

    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if(userRepository.existsByUserName(registerDto.getUserName())){
            throw new InformationExistException(HttpStatus.BAD_REQUEST, "Username is already exists!.", LocalDateTime.now());
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new InformationExistException(HttpStatus.BAD_REQUEST, "Email is already exists!.", LocalDateTime.now());
        }

        UserModel user = new UserModel();
        user.setName(registerDto.getName());
        user.setUserName(registerDto.getUserName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = roleRepository.findByName("ROLE_USER");
        if (userRole.isPresent()) {
            Role role = userRole.get();
            roles.add(role);
            user.setRoles(roles);

            userRepository.save(user);

            return "User registered successfully!.";
        }else {
            throw new InformationNotFoundException(HttpStatus.NOT_FOUND, "Role missing", LocalDateTime.now());
        }
    }
}

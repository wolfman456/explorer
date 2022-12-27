package com.example.explorer.user.UserService.UserServiceImpl;

import com.example.explorer.user.User_model.ERole;
import com.example.explorer.user.User_model.Role;
import com.example.explorer.user.User_model.UserModel;
import com.example.explorer.user.UserService.AuthService;
import com.example.explorer.user.user_repo.RoleRepository;
import com.example.explorer.user.user_repo.UserRepository;
import com.example.explorer.exception.InformationExistException;
import com.example.explorer.security.JwtTokenProvider;
import com.example.explorer.user.User_model.dto.LoginDto;
import com.example.explorer.user.User_model.dto.RegisterDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
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


        UserModel userModel = userRepository.findByEmail(authentication.getName().toString()).get();
                if (userModel.getIsActive() == true) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    return jwtTokenProvider.generateToken(authentication);
                }else {
                    throw new RuntimeException("Login Failure");
                }
    }

    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if (userRepository.existsByUserName(registerDto.getUserName())) {
            throw new InformationExistException(HttpStatus.BAD_REQUEST, "Username is already exists!.", LocalDateTime.now());
        }

        // add check for email exists in database
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new InformationExistException(HttpStatus.BAD_REQUEST, "Email is already exists!.", LocalDateTime.now());
        }

        UserModel user = new UserModel();
        user.setName(registerDto.getName());
        user.setUserName(registerDto.getUserName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setIsActive(true);
        Set<String> strRoles = registerDto.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });

        }

        user.setRoles(roles);
        userRepository.save(user);
        return "User registered successfully!.";
    }
}

package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.data.UserRepository;
import bg.softuni.mobilele.models.dtos.RegisterUserDTO;
import bg.softuni.mobilele.models.dtos.UserLoginDTO;
import bg.softuni.mobilele.models.entities.User;
import bg.softuni.mobilele.service.CurrentUser;
import bg.softuni.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(RegisterUserDTO registerUserDTO) {
        userRepository.save(map(registerUserDTO));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public boolean isLoggedSuccessfully(UserLoginDTO userLoginDTO) {
        User byUsername = findByUsername(userLoginDTO.username());

        if (userLoginDTO.username() == null ||
                userLoginDTO.password() == null ||
                byUsername == null) {
            return false;
        }
        boolean success = passwordEncoder.matches(userLoginDTO.password(), byUsername.getPassword());

        if (success) {
            currentUser.setLoggedIn(true);
            currentUser.setFullName(byUsername.getFirstName() + " " +byUsername.getLastName());
            return true;
        } else {
            currentUser.clear();
        }
        return false;
    }

    @Override
    public void logout() {
        currentUser.clear();
    }

    private User map (RegisterUserDTO registerUserDTO) {
        User registeredUser = modelMapper.map(registerUserDTO, User.class);
        registeredUser.setPassword(passwordEncoder.encode(registerUserDTO.password()));

        return registeredUser;
    }

}

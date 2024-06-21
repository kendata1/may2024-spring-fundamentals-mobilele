package bg.softuni.mobilele.service;

import bg.softuni.mobilele.models.dtos.RegisterUserDTO;
import bg.softuni.mobilele.models.dtos.UserLoginDTO;
import bg.softuni.mobilele.models.entities.User;

public interface UserService {
    void registerUser(RegisterUserDTO registerUserDTO);
    User findByUsername (String username);
    boolean isLoggedSuccessfully (UserLoginDTO userLoginDTO);
    void logout ();
}

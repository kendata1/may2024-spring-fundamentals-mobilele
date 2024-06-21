package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.enums.Role;

import java.util.HashSet;
import java.util.Set;

public record RegisterUserDTO(String firstName,
                              String lastName,
                              String username,
                              String password,
                              Set<Role> roles) {



    public static RegisterUserDTO empty() {
        return new RegisterUserDTO(null,null,null,null,null);
    }
}

package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.dtos.RegisterUserDTO;
import bg.softuni.mobilele.models.enums.Role;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register (Model model){
        model.addAttribute("allRoles", Role.values());

        if(!model.containsAttribute("registerUserDTO")) {
            model.addAttribute("registerUserDTO",RegisterUserDTO.empty());
        }


        return "auth-register";
    }

    @PostMapping("register")
    public String register (RegisterUserDTO registerUserDTO) {

        userService.registerUser(registerUserDTO);

        return "redirect:/users/login";
    }
}

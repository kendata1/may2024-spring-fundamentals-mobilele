package bg.softuni.mobilele.web;

import bg.softuni.mobilele.models.dtos.UserLoginDTO;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/login")
    public String login () {
        return "auth-login";
    }
    @PostMapping("/login")
    public String login (UserLoginDTO userLoginDTO) {

        if (userService.isLoggedSuccessfully(userLoginDTO)) {
            return "redirect:/";
        }
        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout () {
        userService.logout();
        return "redirect:/";
    }
}

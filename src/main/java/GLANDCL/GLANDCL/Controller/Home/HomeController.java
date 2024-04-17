package GLANDCL.GLANDCL.Controller.Home;

import GLANDCL.GLANDCL.Annotation.Login.Login;
import GLANDCL.GLANDCL.Config.Oauth.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(@Login SessionUser user, Model model) {
        if(user!=null) {
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }
}

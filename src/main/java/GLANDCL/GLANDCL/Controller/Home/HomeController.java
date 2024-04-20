package GLANDCL.GLANDCL.Controller.Home;

import GLANDCL.GLANDCL.Annotation.Login.Login;
import GLANDCL.GLANDCL.Config.Oauth.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final HttpSession httpSession;

    // 메인 화면 - 게시판 목록
    @GetMapping("/")
    public String postList(Pageable pageable, Model model) {
//        Page<Post> posts = postService.findAllPosts(pageable);
//        model.addAttribute("posts", posts);

        // 세션에서 사용자 정보 꺼내기
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }
}
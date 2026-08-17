package temp.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import temp.thymeleafdemo.domain.Member;
import temp.thymeleafdemo.service.MemberService;

import static temp.thymeleafdemo.common.ApiConstants.LOGIN_AUTH_END_POINT;
import static temp.thymeleafdemo.common.ApiConstants.LOGIN_END_POINT;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping
    @RequestMapping(LOGIN_END_POINT)
    public String login() {
        return "/login";
    }

    @PostMapping
    @RequestMapping(LOGIN_AUTH_END_POINT)
    public String loginAuth(@ModelAttribute UserForm userForm,
                            HttpServletRequest request
            , RedirectAttributes redirectAttributes) {
        Member member = memberService.getMemberByNameAndPassword(userForm);
        if (member == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "로그인에 실패했습니다");
            return "redirect:/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("member", member);
        return "redirect:/home";
    }
}

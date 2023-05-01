package am.itspace.bookstore.controller;


import am.itspace.bookstore.entity.User;
import am.itspace.bookstore.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MyControllerAdvice {


    //    if we put @ModelAttribute annotation from thymeleaf we can call currentUser ${ currentUser}
    @ModelAttribute(name = "currentUser")
    public User currentUser(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {
            return currentUser.getUser();
        }
        return null;
    }

    //    @ModelAttribute(name = "currentUrl")
//    public String currentUrl(HttpServletRequest request) {
//        String requestURI = request.getRequestURI();
//        if (requestURI.contains("/")) {
//            String[] split = requestURI.split("/");
//            return split[split.length - 1];
//        }
//        return "";
//    }
// nuyn metodne

//    @ModelAttribute(name = "currentUrl")
//    public String currentUrl(HttpServletRequest request) {
//        return request.getRequestURI();
//    }

}

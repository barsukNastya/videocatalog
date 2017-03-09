package com.melenteva.controller;

import com.melenteva.model.User;
import com.melenteva.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.melenteva.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.log4j.Logger;

/**
 * Created by User on 18.02.2017.
 */
@Controller
@SessionAttributes("user")
public class UserController extends HttpServlet {

    @Autowired
    private UserService userService;

    private static final long serialVersionUID = 1L;

    public UserController() {
        super();
    }



    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(Model model, HttpServletRequest request) {

        User userLogin = new User();
        model.addAttribute("userLogin", userLogin);
            return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(Model model, @ModelAttribute("userLogin") User userLogin, HttpServletRequest request) throws ServletException, IOException {
        boolean found = userService.getUserByNameAndPassword(userLogin.getUserName(), userLogin.getUserPassword());
        User user = userService.getUserByNameAndPasswordAndIsAdmin(userLogin.getUserName(),userLogin.getUserPassword(),userLogin.getAdmin());
        if (found) {
            HttpSession session = request.getSession();
            session.setAttribute("name", userLogin.getUserName());
            session.setAttribute("isAdmin", user.getAdmin());
            return "redirect:/videos";
        } else {
            return "failure";
        }
    }

    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(@ModelAttribute("userLogin") User userLogin, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.removeAttribute("name");
        session.invalidate();
        Cookie ck = new Cookie("JSESSIONID","");
        ck.setMaxAge(0);
        response.addCookie(ck);

        return "redirect:/login";
    }
}

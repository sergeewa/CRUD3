package ru.jm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.jm.model.User;
import ru.jm.service.UserService;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("")
    public String listUsers (Model model) {
        List<User> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "list";
    }

    @PostMapping ("/list/add")
    public String addUser (@ModelAttribute("user") User user) throws ServletException, IOException {
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping ("/list/{user.id}/delete")
    public String removeUser (@RequestParam ("id") long id) throws ServletException, IOException {
        userService.removeUser(id);
        return "redirect:/";
    }

    @PostMapping ("/list/{user.id}/edit")
    public String editUser (@ModelAttribute("user") User user) throws ServletException, IOException {
        userService.editUser(user);
        return "redirect:/";
    }

}

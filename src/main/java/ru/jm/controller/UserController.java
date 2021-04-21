package ru.jm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

//    @PostMapping ("/list/add")
//    public String addUser (@ModelAttribute("user") User user) throws ServletException, IOException {
//        userService.add(user);
//        return "list";
//    }

//    @GetMapping()
//    public String showAllUsers(Model model){
//        List<User> allUsers = userService.getAllUsers();
//        model.addAttribute("allUsers", allUsers);
//        return "/all-users";
//    }
//
//    @GetMapping("/{id}")
//    public String showById(@PathVariable("id") long id, Model model){
//
//        model.addAttribute("user", userService.getUserById(id));
//        return "/show";
//    }
//
//
//    @GetMapping("/new")
//    public String addNewUser(Model model){
//        model.addAttribute("user", new User());
//        return "new";
//    }
//
//    @PostMapping()
//    public String createUser(@ModelAttribute("user") User user){
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String editUser(@PathVariable("id") long id, Model model){
//        model.addAttribute("user", userService.getUserById(id));
//        return "edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id){
//
//        userService.updateUser(user, id);
//        return "redirect:/";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") long id){
//        userService.deleteUser(id);
//        return "redirect:/";
//    }
}

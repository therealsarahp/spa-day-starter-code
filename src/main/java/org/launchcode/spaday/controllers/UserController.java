package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute("title", "Create New User");
        if(model.containsAttribute("error")){
            model.addAttribute("username", "username");
            model.addAttribute("email", "email");
        }
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String verify){

        if(user.getPassword().equals(verify)) {

            return "user/index";
        } else {
            int error = 1;
            model.addAttribute("error", error);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());

            return "redirect:add";
        }

    }


}

package org.academiadecodigo.bootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerSpring {

    // Map the URL/Verb to the method
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String card(Model model) {

         User user = generateUser();
// Add an attribute to the request
        model.addAttribute("user", user);

// Return the view name
        return "cena";



        }
    private User generateUser() {

        User user = new User();
        user.setName("Jorge");
        user.setNumber(234325235);
        user.setEmail("jorgeoliveira@gmail.com");
        user.setPassword("123");
        return user;
    }
}


package in.cdac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.cdac.dao.User;
import jakarta.validation.Valid;

@Controller
public class FirstController {
    
    @RequestMapping("/")
    public String welcome(){
        return "index";
    }

    @RequestMapping("/home")
    public String goToHome(){
        return "home";
    }

    @RequestMapping(value="/userlogin", method = RequestMethod.GET)
    public String goToLogin(){
        return "login";
    }

    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
    public String authenticate(@RequestParam("useremail") String email,
        @RequestParam("userpassword") String password, Model model){
            
            if(email.equals("admin@cdac.in") && password.equals("cdac@123")){
                model.addAttribute("msg", "Welcome "+email);
                return "welcome";
            }
            else{
                 model.addAttribute("msg", "Invalid User Details");
            }
        return "login";
    }

    @RequestMapping("/register")
    public ModelAndView goToRegister(){
        return new ModelAndView("register","command", new User());
    }

     @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String registerUserDetails(@Valid @ModelAttribute("userObj") User user, Model model, BindingResult br){
        
        System.out.println("---> "+br.hasErrors());
        if(br.hasErrors()){
            return "register";
        }else{
            model.addAttribute("msg", "Welcome "+user.getUsername());
            return "welcome";
        }
    }
}

package com.example.opentravel.controller;

import com.example.opentravel.model.User;
import com.example.opentravel.service.StorageService;
import com.example.opentravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@Transactional
public class LoginController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, @RequestParam(name = "file",required = false) MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("hello");
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "*There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            user.setImage("member.png");
            if (file!=null && !file.isEmpty()){
                storageService.saveAvatar(file);
                user.setImage(file.getOriginalFilename());
            }
            if (user.getCountry()==null || user.getCountry().equalsIgnoreCase("")) {
                user.setCountry("Kyrgyzstan");
                user.setStatus("gid");
                userService.saveUser(user, "GID");
                modelAndView.addObject("successMessage", "User has been registered successfully as GID");
            }
            else {
                user.setStatus("tourist");
                userService.saveUser(user, "TOURIST");
                modelAndView.addObject("successMessage", "User has been registered successfully as Tourist");
            }

            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");

        }
        return modelAndView;
    }
    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> reset(@RequestParam("email") String email, HttpServletRequest request) {
        int result =0 ;
        User user=userService.findUserByEmail(email);
        if (user!=null) {
            userService.sendTokenToReset(user,request);
            result = 1;
        }
        return ResponseEntity.ok(result);

    }
    @RequestMapping("/reset")
    public String  reset(@RequestParam("token") String token,Model model){
        User user=userService.findByToken(token);
        if(user==null){
            return "error";
        }
        else {
            model.addAttribute("token",token);
            return "reset";
        }
    }

    @RequestMapping(value = "/newPassword", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> newPassword(@RequestParam("password") String password,@RequestParam("token") String token,Model model) {
        User user=userService.findByToken(token);
        if (user!=null) {
            userService.saveNewPas(user,password);
            return ResponseEntity.ok(1);
        }
        return ResponseEntity.ok(0);
    }
}

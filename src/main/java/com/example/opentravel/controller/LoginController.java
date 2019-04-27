package com.example.opentravel.controller;

import com.example.opentravel.model.User;
import com.example.opentravel.service.StorageService;
import com.example.opentravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView login(@RequestParam(value = "lang",defaultValue = "eng", required = false) String lang){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        if(lang.equals("eng")) {
            modelAndView.addObject("eng",true);
        }
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;


    @RequestMapping("/confirm")
    public String  confirm(@RequestParam("token") String token, Model model){
        User user=userService.findByToken(token);
            user.setActive(1);
            userService.save(user);
            return "redirect:/login";
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
    public String  reset(@RequestParam("token") String token, Model model){
        User user=userService.findByToken(token);
        model.addAttribute("token",token);
        return "reset";
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

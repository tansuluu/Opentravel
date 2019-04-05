package com.example.opentravel.service;

import com.example.opentravel.model.Blog;
import com.example.opentravel.model.Place;
import com.example.opentravel.model.Role;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.RoleRepository;
import com.example.opentravel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private BlogService blogService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private EmailService emailService;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user,String role) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(0);
        Role userRole = roleRepository.findByRole(role);
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public User saveNewPas(User user,String pas){
        user.setPassword(bCryptPasswordEncoder.encode(pas));
        user.setToken("");
        return userRepository.save(user);
    }
    public ArrayList<User> getAllByStatus(String status){
        ArrayList<User> list=(ArrayList<User>)userRepository.getAllByStatus(status);
        ArrayList<User> finalist=new ArrayList<>();
        finalist.add(list.get(0));
        finalist.add(list.get(1));
        finalist.add(list.get(2));
        return finalist;
    }
    public ArrayList<User> getAll()
    {
        return (ArrayList) userRepository.getAllByOrderByAboutMe();
    }

    public ArrayList<User> findByName(String name){
        return (ArrayList<User>) userRepository.findAllByName(name);
    }


    public User findByToken(String token){
        return userRepository.findByToken(token);
    }


    public void sendTokenToReset(User user, HttpServletRequest request){
        user.setToken(UUID.randomUUID().toString());

        String appUrl = request.getScheme() + "://" + request.getServerName();

        SimpleMailMessage registrationEmail = new SimpleMailMessage();
        registrationEmail.setTo(user.getEmail());
        registrationEmail.setSubject("Password reset");
        registrationEmail.setText("To reset your password on opentravel site, please click the link below:\n"
                + appUrl + ":8080/reset?token=" + user.getToken());
        registrationEmail.setFrom("noreply@domain.com");
        emailService.sendEmail(registrationEmail);
    }

    public void sendTokenToConfirm(User user, HttpServletRequest request){
        user.setToken(UUID.randomUUID().toString());

        String appUrl = request.getScheme() + "://" + request.getServerName();

        SimpleMailMessage registrationEmail = new SimpleMailMessage();
        registrationEmail.setTo(user.getEmail());
        registrationEmail.setSubject("Confirmation to OpenTravel site");
        registrationEmail.setText("To confirm your gmail on opentravel site, please click the link below:\n"
                + appUrl + ":8080/confirm?token=" + user.getToken());
        registrationEmail.setFrom("noreply@domain.com");
        emailService.sendEmail(registrationEmail);
    }
    public User save(User user){
        return userRepository.save(user);
    }

    public void deleteUser(User user){
Repository.delete(user);
    }
}
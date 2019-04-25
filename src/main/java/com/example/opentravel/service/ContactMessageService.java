package com.example.opentravel.service;


import com.example.opentravel.model.ContactMessage;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service("contactMessageService")
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public ContactMessage findById(long id){
        return contactMessageRepository.findById(id);
    }

    public List<ContactMessage> getAll(){
        return contactMessageRepository.findAll();
    }

    public void save(ContactMessage contactMessage){
        contactMessage.setDate(Calendar.getInstance().getTime());
        contactMessage.setAnswered(0);
        contactMessageRepository.save(contactMessage);
    }

    public void delete(long id){
        contactMessageRepository.delete(findById(id));
    }

    public void reply( HttpServletRequest request,String email){
        String appUrl = request.getScheme() + "://" + request.getServerName();

        SimpleMailMessage registrationEmail = new SimpleMailMessage();
        registrationEmail.setTo(email);
        registrationEmail.setSubject("Password reset");
        registrationEmail.setText("Hello "+ user.getName()+"!\n" +
                "To reset your password on opentravel site, please click the link below:\n"
                + appUrl + ":8080/reset?token=" + user.getToken());
        registrationEmail.setFrom("noreply@domain.com");
        emailService.sendEmail(registrationEmail);
    }
}

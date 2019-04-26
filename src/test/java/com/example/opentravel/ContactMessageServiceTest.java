package com.example.opentravel;

import com.example.opentravel.model.ContactMessage;
import com.example.opentravel.repository.ContactMessageRepository;
import com.example.opentravel.service.ContactMessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactMessageServiceTest {

    @Mock
    ContactMessageRepository contactMessageRepositoryMock;

    @Autowired
    ContactMessageRepository contactMessageRepository;

    @InjectMocks
    ContactMessageService contactMessageService;

    @Before
    public void setUp(){
        System.out.println("Starting ContactMessageService Test Class");
    }

    @Test
    public void testFindById(){
        ContactMessage contactMessage = new ContactMessage();
        long id = 1;
        contactMessage.setId(id);
        when(contactMessageRepositoryMock.findById(id)).thenReturn(contactMessage);
        assertEquals(contactMessage,contactMessageRepositoryMock.findById(id));
    }

    @Test
    public void testFindByIdWhenNoSuchId(){
        ContactMessage contactMessage=new ContactMessage();
        long id=0;
        when(contactMessageRepositoryMock.findById(id)).thenReturn(contactMessage);
        assertEquals(contactMessage,contactMessageRepositoryMock.findById(id));
    }

    @Test
    public void testGetAllContactMessages() {

        ContactMessage contactMessage = new ContactMessage();

        ContactMessage contactMessage1 = new ContactMessage();


        List<ContactMessage> contactMessages = new ArrayList<>();
        contactMessages.add(contactMessage);
        contactMessages.add(contactMessage1);
        when(contactMessageRepositoryMock.findAll()).thenReturn(contactMessages);
        assertEquals(contactMessages, contactMessageService.getAll());
    }

    @Test
    public void testDelete() {
        ContactMessage contactMessage = new ContactMessage();

        int doseId=1;
        contactMessage.setId(doseId);
        // perform the call
        contactMessageService.delete(contactMessage.getId());

        // verify the mocks
        //assertEquals(blog,blogServiceTest.findById(doseId));

    }

    @After
    public void terminate(){
        System.out.println("Terminating Test Class");
    }
}

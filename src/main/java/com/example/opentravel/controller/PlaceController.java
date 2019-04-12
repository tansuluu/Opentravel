package com.example.opentravel.controller;


import com.example.opentravel.model.Blog;
import com.example.opentravel.model.Place;
import com.example.opentravel.model.PlaceComment;
import com.example.opentravel.model.User;
import com.example.opentravel.repository.PlaceRepository;
import com.example.opentravel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Transactional
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @Autowired
    StorageService storageService;

    @Autowired
    UserService userService;

    @Autowired
    private PlaceCommentService placeCommentService;

    @RequestMapping(value = "/newPlace", method = RequestMethod.GET)
    public String newPlace(Model model) {
        Place form = new Place();
        model.addAttribute("place", form);
        return "newPlace";
    }

    @RequestMapping(value = "/newPlace", method = RequestMethod.POST)
    public String saveRegister(@ModelAttribute("place")@Valid Place place,
                               BindingResult result, Model model, //
                               Principal principal, @RequestParam(name = "file1", required = false)MultipartFile file1,
                               @RequestParam(name = "file2", required = false)MultipartFile file2, @RequestParam(name = "file3", required = false)MultipartFile file3) {
        if (result.hasErrors()) {
            model.addAttribute("place", place);
            System.out.println("errorr with place");
            return "newPlace";
        }

        try {
            place=storageService.preStore(file1,file2,file3,place);
            User user=userService.findUserByEmail(principal.getName());
            place.setAuthor(user);
            placeService.save(place);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            model.addAttribute("place", place);
            model.addAttribute("message","There is already exist such image");
            return "newPlace";
        }

        return "redirect:/userPage?username="+principal.getName();
    }


    @RequestMapping("/places")
    public String places(@RequestParam(value = "page",defaultValue = "1") int page,Model model){
        PageRequest pageRequest=PageRequest.of(page-1,5);
        Page<Place> adminPage=placeService.getAll(pageRequest);
        int total=adminPage.getTotalPages();
        if(total>0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1,total).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("places",adminPage.getContent());
        return "allPlaceS";
    }
    @RequestMapping("/findPlace")
    public String find(@RequestParam(name = "input",required = true) String input, Model model){
        ArrayList<Place> list=placeService.findByTitle(input);
        model.addAttribute("places", list);
        return "allPlaceS";
    }

    @RequestMapping("/placeInfo")
    public String showApplications(Model model, @RequestParam("id")long id, Principal principal){
        Place place=placeService.findById(id);
        List<PlaceComment> placeComments=placeCommentService.findByPlace(place);
        List<Place> popular=placeService.getTop3PlaceByOrderByView();
        model.addAttribute("app",place);
        model.addAttribute("popular",popular);
        model.addAttribute("comments",placeComments);

        return "places";
    }

    @RequestMapping("/deleteAppP")
    public String showApplications( @RequestParam("id")long id){
        placeService.delete(id);
        return "redirect:/places";
    }

    @RequestMapping("/updateApp")
    public String update(Model model, @RequestParam("id")long id){
        model.addAttribute("place", placeService.findById(id));
        return "updatePlace";
    }

    @RequestMapping(value = "/updateApp",method = RequestMethod.POST)
    public String update(@Valid Place place){
        Place place1=placeService.findById(place.getId());
        place1.setText(place.getText());
        place1.setTitle(place.getTitle());
        place1.setCategory(place.getCategory());
        place1.setAddress(place.getAddress());
        placeService.save(place1);
        return "redirect:/placeInfo?id="+place.getId();
    }


    @RequestMapping(value = "/newComment",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<?> newComment(@RequestParam("comment") String text, @RequestParam("appId") long id,Principal principal){
        PlaceComment placeComment=placeCommentService.save(text,id,userService.findUserByEmail(principal.getName()));
        return ResponseEntity.ok(placeComment);
    }

    @RequestMapping("/deleteComment")
    public String deleteComment(@RequestParam("id") long id, @RequestParam("placeId") long placeId){
        placeCommentService.deleteComment(id,placeService.findById(placeId));
        return "redirect:/placeInfo?id="+placeId+"#comm";
    }
}
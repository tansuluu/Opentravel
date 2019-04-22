package com.example.opentravel.controller;

import com.example.opentravel.model.*;
import com.example.opentravel.service.*;
/*import javafx.geometry.Pos;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
public class UserController {


    @Autowired
    private StorageService storageService;

    @Autowired
    UserService userService;

    @Autowired
    BlogService blogService;

    @Autowired
    PlaceService placeService;

    @Autowired
    private PostService postService;

    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping("/find")
    public String find(@RequestParam(name = "input", required = true) String input, Model model) {
        ArrayList<User> list = userService.findByName(input);
        model.addAttribute("gids", list);
        return "gids";
    }

    @RequestMapping("/userPage")
    public String showUser(Model model, @RequestParam("username") String email) {
        User user = userService.findUserByEmail(email);
        List<Place> list = placeService.findByAuthor(user);
        List<Blog> list1 = blogService.findByAuthor(user);
        List<Post> list2= postService.findByUser(user);
        model.addAttribute("places", list);
        model.addAttribute("posts", list2);
        model.addAttribute("blogs", list1);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/image/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        String mimeType = "";
        try {
            mimeType = Files.probeContentType(file.getFile().toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/up-avatar/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getAvatar(@PathVariable String filename) {
        Resource file = storageService.loadAvatar(filename);
        String mimeType = "";
        try {
            mimeType = Files.probeContentType(file.getFile().toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id,Principal principal){
        User user=userService.findUserByEmail(principal.getName());
        userService.deleteUser(id);
        if(user.getStatus().equals("admin")){
            return "redirect:/admin";
        }
        return "redirect:/logout";
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String updateUser(@Valid User user){
        userService.updateUser(user);
        return "redirect:/userPage?username="+user.getEmail();
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.GET)
    public String updateUser(@RequestParam("id") int id,Model model){
        User user=userService.findUserById(id);
        System.out.println(user.getPassword());
        model.addAttribute("user",user);
        return "updateUser";
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> addComment(@RequestParam("post") String text, @RequestParam("username") String username, Principal principal) {
        Post post=postService.save(principal.getName(), username, text);
        return ResponseEntity.ok(post);
    }

    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam("id") long id, @RequestParam("username") String username){
        postService.deleteById(id);
        return "redirect:/userPage?username="+username+"#postt";
    }

    @RequestMapping(value="/updatePost",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<?> updatePlaceComment(@RequestParam("id") long id){
        Post post=postService.findById(id);
        return ResponseEntity.ok(post);
    }

    @RequestMapping(value="/updatePostSave",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<?> updatePlaceCommentSave(@RequestParam("id") long id,@RequestParam("text") String text){
        postService.updatePost(id,text);
        return ResponseEntity.ok(1);
    }

    @RequestMapping("/favoriteUser")
    public String favoriteUser(Model model,Principal principal){
        List<Favorite> list=favoriteService.getByUser(userService.findUserByEmail(principal.getName()));
        List<Place> list1= placeService.findFavorite(list);
        model.addAttribute("places",list1);
        model.addAttribute("favorite","Favorite places!");

        return "allPlaceS";
    }


}
package com.tns.post.controller;

import com.tns.post.client.UserClient;
import com.tns.post.entity.Post;
import com.tns.post.entity.User;
import com.tns.post.repository.PostRepository;
import com.tns.post.service.IPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final IPostService  iPostService;
    private final UserClient userClient;

    public PostController(IPostService iPostService, UserClient userClient) {
        this.iPostService = iPostService;
        this.userClient = userClient;
    }

    @PostMapping
    public Post createPost(@RequestBody Post  post){
        return iPostService.createPost(post);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Integer id){
        return this.iPostService.getPost(id);
    }

    @GetMapping
    public List<Post> getAllPost(){
       List<Post> posts =  this.iPostService.getAllPost();
        System.out.println("Users : "+userClient.getAllUser());
        List<User> users = userClient.getAllUser();

        for(User u:users){
            System.out.println(u);
            System.out.println(u.getId()+" "+u.getName());
        }

        for(Post post:posts){
            post.setUsers(users);
        }
        return posts;
    }


}

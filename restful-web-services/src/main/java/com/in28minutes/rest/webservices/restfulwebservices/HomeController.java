package com.in28minutes.rest.webservices.restfulwebservices;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Prasanna.Mondhe on 12/21/2018.
 */

@RestController
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping(path="/home")
    public String getHelloMsg(){
        return "Hello Prasanna";
    }

    @GetMapping(path = "/home-bean")
    public HelloBean getHelloBeanMsg(){
        return new HelloBean(1,"Hello Prasanna, This is bean",2);
    }

    @PostMapping(path = "/home-created")
    public void createdRecord(@Valid @RequestBody HelloBean helloBean){
        userService.save(helloBean);
    }

    @GetMapping(path = "/home-getAllRecord")
    public List<HelloBean> getAllRecord(){
        return userService.getAllUser();
    }

    @GetMapping(path = "/home-getSingleRecord/{id}")
    public Resource<HelloBean> findOne(@PathVariable Integer id){
        HelloBean helloBean = userService.findOne(id);

        Resource<HelloBean> resource = new Resource<HelloBean>(helloBean);

        ControllerLinkBuilder linkBuilder = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllRecord());
        resource.add(linkBuilder.withRel("all-record"));


        linkBuilder = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getHelloBeanMsg());
        resource.add(linkBuilder.withRel("Hello Message"));


        return resource;
    }
}



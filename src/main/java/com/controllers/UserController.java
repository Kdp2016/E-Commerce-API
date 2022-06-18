package com.controllers;

import com.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<User>();
        userList.addAll(Arrays.asList(
                new User(1, "Goku", "Kakarot", "goku@gmail.com", "someaddres", "goku124", 2),
                new User(2, "Goku", "Kakarot", "goku@gmail.com", "someaddres", "goku124", 2),
                new User(3, "Goku", "Kakarot", "goku@gmail.com", "someaddres", "goku124", 2)));

        return userList;
    }

    public String sanity() {
        return "/users works!";
    }


}


//public class TestController {

//    @GetMapping
//    public String sanity() {
//        return "/test works!";
//    }
//
//    @GetMapping("/example-1")
//    public String example1() {
//        return "/test/example-1 works!";
//    }
//
//    @GetMapping("/example-2")
//    public String example2(@RequestParam("exampleKey") String key) {
//        return "Value provided in exampleKey: " +  key;
//    }
//
//    @GetMapping("/example-3/{pathVar}")
//    public String example3(@PathVariable String pathVar) {
//        return "Value provided in pathVar: " + pathVar;
//    }
//
//    @GetMapping("/example-4")
//    public String example4(@RequestHeader String myHeader) {
//        return "Value provided in myHeader: " + myHeader;
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping(value = "/example-5", consumes = "application/json")
//    public NewTaskRequest example5(@RequestBody NewTaskRequest task) {
//        task.setId(UUID.randomUUID().toString());
//        return task;
//    }

//}

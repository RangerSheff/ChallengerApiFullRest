package com.example.ChallengerApiRestFull.CRUD.Controller;

import com.example.ChallengerApiRestFull.CRUD.Service.UsersService;
import com.example.ChallengerApiRestFull.CRUD.Models.UsersModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @GetMapping(path = "/findAll")
    public ArrayList<UsersModels> getUsers (){
        return usersService.getUsers();
    }

    @GetMapping(path = "/find/{id}")
    public Optional<UsersModels> getUserById(@PathVariable("id") int id){
        return usersService.getById(id);
    }

    @PostMapping(path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersModels saveUser(@RequestBody UsersModels user){
        return usersService.saveUser(user);
    }

    @PutMapping(path = "/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UsersModels updateUserById(@RequestBody UsersModels userMod,@PathVariable("id") int id){
        return usersService.updateById(userMod,id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public Boolean deleteById(@PathVariable("id") int id){
        return usersService.deleteById(id);
    }
}

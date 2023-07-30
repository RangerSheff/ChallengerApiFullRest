package com.example.ChallengerApiRestFull.CRUD.Controller;

import com.example.ChallengerApiRestFull.CRUD.Models.UsersRequestCreatedSave;
import com.example.ChallengerApiRestFull.CRUD.Service.UsersService;
import com.example.ChallengerApiRestFull.CRUD.Models.UsersModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<UsersModels> getUserById(@PathVariable("id") UUID id){
        return usersService.getById(id);
    }

    @PostMapping(path = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersModels saveUser(@RequestBody UsersRequestCreatedSave user){
        return usersService.saveUser(user);
    }

    @PutMapping(path = "/update/{id}")
    public UsersModels updateUserById(@RequestBody UsersRequestCreatedSave userMod,@PathVariable("id") UUID id){
        return usersService.updateById(userMod,id);
    }
    @DeleteMapping(path = "/delete/{id}")
    public Boolean deleteById(@PathVariable("id") UUID id){
        return usersService.deleteById(id);
    }
}

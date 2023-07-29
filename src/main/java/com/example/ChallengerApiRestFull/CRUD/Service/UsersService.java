package com.example.ChallengerApiRestFull.CRUD.Service;

import com.example.ChallengerApiRestFull.CRUD.Models.UsersModels;
import com.example.ChallengerApiRestFull.CRUD.Repositories.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    IUsersRepository usersRepository;

    public ArrayList<UsersModels> getUsers (){
        return (ArrayList<UsersModels>) usersRepository.findAll();
    }

    public Optional<UsersModels> getById(int id){
        var result = usersRepository.findById(id);

        if(result.isPresent()){
            return result;
        }
        else {
            return  Optional.of(new UsersModels());
        }
    }

    public UsersModels saveUser(UsersModels user){

        return usersRepository.save(user);
    }

    public UsersModels updateById(UsersModels userMod, int id){
        UsersModels user = usersRepository.findById(id).get();

        /*user.setName(userMod.getName());
        user.setEmail(userMod.getEmail());
        user.setPassword(userMod.getPassword());
        user.setTelephone(user.getTelephone());
        user.setActive(userMod.getActive());
*/
        return user;
    }

    public Boolean deleteById(int id){
        try{
            usersRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

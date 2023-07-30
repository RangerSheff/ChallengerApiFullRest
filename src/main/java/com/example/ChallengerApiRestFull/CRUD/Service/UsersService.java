package com.example.ChallengerApiRestFull.CRUD.Service;

import com.example.ChallengerApiRestFull.CRUD.Models.UsersModels;
import com.example.ChallengerApiRestFull.CRUD.Models.UsersRequestCreatedSave;
import com.example.ChallengerApiRestFull.CRUD.Repositories.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    IUsersRepository usersRepository;

    public ArrayList<UsersModels> getUsers (){
        return (ArrayList<UsersModels>) usersRepository.findAll();
    }

    public Optional<UsersModels> getById(UUID id){
        var result = usersRepository.findById(id);

        if(result.isPresent()){
            return result;
        }
        else {
            return  Optional.of(new UsersModels());
        }
    }

    public UsersModels saveUser(UsersRequestCreatedSave user){

        if (!user.getEmail().matches("[^@]+@[^@]+\\.[^@]+")) {
            throw new IllegalArgumentException("Formato de correo inválido");
        }

        if (!user.getPassword().matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z0-9@#$%^&+=]{5,25}")) {
            throw new IllegalArgumentException("Formato de password inválido");
        }

        UsersModels existingUser = usersRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new IllegalArgumentException("El correo ya registrado");
        }

        UsersModels userSave = new UsersModels(user.getName(), user.getEmail(), user.getPassword(), user.getPhones(),user.getIsActive());
        return usersRepository.save(userSave);
    }

    public UsersModels updateById(UsersRequestCreatedSave userMod, UUID id){
        UsersModels user = usersRepository.findById(id).get();

        if (!userMod.getEmail().matches("[^@]+@[^@]+\\.[^@]+")) {
            throw new IllegalArgumentException("Formato de correo inválido");
        }

        if (!userMod.getPassword().matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z0-9@#$%^&+=]{5,25}")) {
            throw new IllegalArgumentException("Formato de password inválido");
        }

        UsersModels userUpdate = new UsersModels(user.getId(), userMod.getName(), userMod.getEmail(), userMod.getPassword(), user.getCreated(),
                userMod.getPhones(), user.getToken(), userMod.getIsActive());
        usersRepository.save(userUpdate);
        return userUpdate;
    }

    public Boolean deleteById(UUID id){
        try{
            usersRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

package com.example.ChallengerApiRestFull.CRUD.Repositories;

import com.example.ChallengerApiRestFull.CRUD.Models.UsersModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<UsersModels, Integer> {


}

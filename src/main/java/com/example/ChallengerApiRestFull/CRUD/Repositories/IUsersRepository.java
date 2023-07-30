package com.example.ChallengerApiRestFull.CRUD.Repositories;

import com.example.ChallengerApiRestFull.CRUD.Models.UsersModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUsersRepository extends JpaRepository<UsersModels, UUID> {
    UsersModels findByEmail(String email);
}

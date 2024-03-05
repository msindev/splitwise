package net.penguincoders.splitwise.services;

import net.penguincoders.splitwise.dataaccess.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UsersRepository usersRepository;


}

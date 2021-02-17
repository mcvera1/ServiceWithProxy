package com.service;

import com.dto.User;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class UserInterfaceImpl implements  UserInterface{

    List<User> userList = Arrays.asList(new User(1L,"Name1","LastName1"), new User(2L,"Name2","LastName2"));

    @Override
    public User getUser(long id) {
        return userList.stream().filter(userId -> userId.getId() == id).findFirst().get();
    }
}

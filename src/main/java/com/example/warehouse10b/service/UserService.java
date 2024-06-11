package com.example.warehouse10b.service;

import com.example.warehouse10b.dto.UserDto;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.model.User;
import com.example.warehouse10b.model.WareHouse;
import com.example.warehouse10b.repository.UserRepository;
import com.example.warehouse10b.repository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WareHouseRepository wareHouseRepository;

    public List<User> getAllUser(){
        List<User>userList=userRepository.findAll();
        return userList;
    }

    public User getByIdUser(Integer id){
        Optional<User>userOptional=userRepository.findById(id);
        return userOptional.get();
    }

    public Result aaNewUser(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCode(userDto.getCode());
        user.setPassword(userDto.getPassword());

        user.setActive(userDto.isActive());
        Optional<WareHouse>wareHouseOptional=wareHouseRepository.findById(userDto.getWareHouseId());
        user.setWareHouses((List<WareHouse>) wareHouseOptional.get());

        userRepository.save(user);
        return new Result(true,"User add");
    }

    public Result editUser(UserDto userDto,Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User user=optionalUser.get();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setCode(userDto.getCode());
            user.setPassword(userDto.getPassword());
            user.setActive(userDto.isActive());
            userRepository.save(user);
            return new Result(true,"User update");
        }
        return new Result(false,"User not found");
    }

    public Result deleteUserId(Integer id){
        userRepository.deleteById(id);
        return new Result(true,"User deleted");
    }

}

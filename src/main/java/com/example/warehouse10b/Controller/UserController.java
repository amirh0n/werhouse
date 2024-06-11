package com.example.warehouse10b.Controller;

import com.example.warehouse10b.dto.UserDto;
import com.example.warehouse10b.model.Result;
import com.example.warehouse10b.model.User;
import com.example.warehouse10b.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public List<User>getUser(){
        List<User>userList=userService.getAllUser();
        return userList;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN','ADMIN')")
    public User getByIdUser(@PathVariable Integer id){
        User serviceByIdUser=userService.getByIdUser(id);
        return serviceByIdUser;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Result create(@RequestBody UserDto userDto){
        Result result = userService.aaNewUser(userDto);
        return result;
    }

    @PutMapping("{/id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Result update(@PathVariable Integer id,@RequestBody UserDto userDto){
        Result result=userService.editUser(userDto,id);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Result result=userService.deleteUserId(id);
        return result;
    }
}

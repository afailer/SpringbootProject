package com.tjwq.demo.controller;

import com.tjwq.demo.domain.JsonData;
import com.tjwq.demo.domain.User;
import com.tjwq.demo.mapper.UserMapper;
import com.tjwq.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/user", method = RequestMethod.GET)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("add")
    public Object add(){
        User user = new User("andy","942936546@163.com","29",new Date());
        int id = userService.add(user);
        return id;
    }

    @GetMapping("find_all")
    public Object findAll(){
        return JsonData.buildSuccess(userMapper.findAll());
    }

    @GetMapping("find_by_id")
    public Object findById(long id){
        return JsonData.buildSuccess(userMapper.findById(id));
    }

    @GetMapping("del_by_id")
    public Object delById(long id){
        userMapper.delete(id);
        return JsonData.buildSuccess();
    }

    @GetMapping("update")
    public Object update(String name, int id){
        User user = new User();
        user.setName(name);
        user.setId(id);
        userMapper.update(user);
        return JsonData.buildSuccess();
    }
}

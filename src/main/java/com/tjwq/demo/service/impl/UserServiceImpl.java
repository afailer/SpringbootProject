package com.tjwq.demo.service.impl;

import com.tjwq.demo.domain.User;
import com.tjwq.demo.mapper.UserMapper;
import com.tjwq.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(User user){
        userMapper.insert(user);
        int id = user.getId();
        return id;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addAccount() {
        User user = new User();
        user.setAge("99");
        user.setCreateTime(new Date());
        user.setName("test");
        user.setEmail("1001010");
        userMapper.insert(user);
        return 0;
    }

}

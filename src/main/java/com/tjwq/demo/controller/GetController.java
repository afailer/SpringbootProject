package com.tjwq.demo.controller;


import com.tjwq.demo.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GetController {

    private Map<String,Object> params = new HashMap<>();

    @RequestMapping(path = "/v1/{city_id}/{user_id}", method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId,
                           @PathVariable("user_id") String userId){
        params.clear();
        params.put("cityId", cityId);
        params.put("userId", userId);
        System.out.println("sdfsfdsdf");
        return params;
    }

    @GetMapping(value="/v1/page_user1")
    public Object pageUser(int from, int size){
        params.clear();
        params.put("from",from);
        params.put("size", size);

        return params;
    }

    @GetMapping(value="/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue = "0", name = "page") int from, int size ){
        params.clear();
        params.put("from",from);
        params.put("size", size);

        return params;
    }


    @RequestMapping("/v1/save_user")
    public Object saveUser(@RequestBody User user){
        params.clear();
        params.put("user",user);
        return params;
    }

    @GetMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id){
        params.clear();
        params.put("access_token", accessToken);
        params.put("id", id);

        return params;
    }

    @GetMapping("/v1/test_request")
    public Object testRequest(HttpServletRequest request){

        params.clear();
        String id = request.getParameter("id");
        params.put("id", id);

        return params;
    }

    @GetMapping("/v1/get_user")
    public Object getUser(){
        return new User("andy" ,"942936546@qq.com","29", new Date());
    }
}

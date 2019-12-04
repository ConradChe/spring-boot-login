package com.test.springbootlogin.controller;

import com.test.springbootlogin.mapper.UserMapper;
import com.test.springbootlogin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String findUser(User user, Model m, Map<String, Object> map, HttpSession session) {
        User u = userMapper.find(user.getName());
        if (u != null && u.getPassword().equals(user.getPassword())) {
            m.addAttribute("u", u);
            session.setAttribute("user", user);
            return "success";
        } else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }

    @ResponseBody
    @RequestMapping("/checkemail")
    public String checkemail(String name) {
        User u = userMapper.find(name);
        if (u != null) {
            return "该邮箱已被注册";
        }
        return "";
    }

    @RequestMapping("insertUser")
    public String insertUser(User u, Model m) {
        if (userMapper.find(u.getName()) == null) {
            userMapper.insert(u);
            return "login";
        } else {
            m.addAttribute("msg", "注册失败！");
            return "regist";
        }
    }

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }
}

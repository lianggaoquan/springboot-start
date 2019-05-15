package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    /**
     * 添加用户
     */
    @RequestMapping("/addUser")
    public String addUser(User user){
        this.userService.addUser(user);
        return "ok";
    }

    /**
     * 查询所有用户
     */
    @RequestMapping("/findUserAll")
    public String findUserAll(Model model){
        List<User> list = userService.findUserAll();
        model.addAttribute("list",list);
        return "showUsers";
    }

    /**
     * 根据id查找用户
     */
    @RequestMapping("/findUserById")
    public String findUserById(Integer id,Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }

    /**
     * 修改用户信息
     *
     */
    @RequestMapping("/editUser")
    public String editUser(User user){
        this.userService.updateUser(user);
        return "ok";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delUser")
    public String delUser(Integer id){
        this.userService.deleteUserById(id);
        return "redirect:/user/findUserAll";
    }

}

package com.hctek.controller;

import com.hctek.dao.UserMapper;
import com.hctek.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.List;

/**
 * Created by Azurs on 2017-01-25.
 */
@Controller
public class MainController {
    ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    //获得一个BEAN USER表操作对象
    UserMapper UserDao=ctx.getBean(UserMapper.class);
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return "index";
    }
    @ResponseBody
    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public User getUsers(ModelMap modelMap) {
        // 查询user表中所有记录
        //初始化容器
        List<User> UserList=UserDao.getAllUsers();
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        //modelMap.addAttribute("userList", UserList);

        // 返回pages目录下的admin/users.jsp页面
       // return "admin/users";
        User user = UserDao.selectByPrimaryKey(1);
        return  user;
    }

    // get请求，访问添加用户 页面
    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        // 转到 admin/addUser.jsp页面
        return "admin/addUser";
    }

    // post请求，处理添加用户请求，并重定向到用户管理页面
    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") User userEntity) {
        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象
        //@ModelAttribute注解：收集post过来的数据（在此，相当于post过来了一整个userEntity，不用一个一个地取）

        // 数据库中添加一个用户，该步暂时不会刷新缓存
        UserDao.insert(userEntity);

        // 数据库中添加一个用户，并立即刷新缓存
 //       userRepository.saveAndFlush(userEntity);

        // 重定向到用户管理页面，方法为 redirect:url
        return "redirect:/admin/users";
    }

    // 查看用户详情
    // @PathVariable可以收集url中的变量，需匹配的变量用{}括起来
    // 例如：访问 localhost:8080/admin/users/show/1 ，将匹配 id = 1
    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        // 找到userId所表示的用户
 //       UserEntity userEntity = userRepository.findOne(userId);

        // 传递给请求页面
        modelMap.addAttribute("user", UserDao.selectByPrimaryKey(userId));
        return "admin/userDetail";
    }

    // 更新用户信息 页面
    @RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        // 找到userId所表示的用户
//        UserEntity userEntity = userRepository.findOne(userId);

        // 传递给请求页面
//        modelMap.addAttribute("user", userEntity);
        modelMap.addAttribute("user", UserDao.selectByPrimaryKey(userId));
        return "admin/updateUser";
    }

    // 更新用户信息 操作
    @RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") User userEntity) {

        // 更新用户信息
        UserDao.updateByPrimaryKeySelective(userEntity);

        return "redirect:/admin/users";
    }

    // 删除用户
    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {

        // 删除id为userId的用户
//        userRepository.delete(userId);
        UserDao.deleteByPrimaryKey(userId);
        // 立即刷新
//        userRepository.flush();
        return "redirect:/admin/users";
    }
 /*   */
}

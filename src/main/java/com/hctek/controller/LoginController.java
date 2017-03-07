package com.hctek.controller;

import javax.servlet.http.HttpServletResponse;

import com.hctek.dao.UserMapper;
import com.hctek.model.User;
import com.hctek.myImpl.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * LoginController例子
 *
 * @version 1.0
 * @author foolbeargm@gmail.com
 */
@Controller
@CrossOrigin
@RequestMapping("/api")
public class LoginController {
    ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    //获得一个BEAN USER表操作对象
    UserMapper UserDao=ctx.getBean(UserMapper.class);
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 返回当前登录用户的用户名
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "getCurrentUser", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> getCurrentUser() {
        // TODO: 填写自己的逻辑
       // return CommonResult.errorReturn(10,"Not Login Yet");
        return CommonResult.successReturn("guest");
    }

    /**
     * 校验用户信息，成功则返回当前登录的用户名
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> login(String username, String password) {
        // TODO: 填写自己的逻辑
        logger.info("username = {}", username);
        CommonResult<String> resultList;
        User dbUser = UserDao.selectByName(username);
        if(dbUser != null){
            if(username.equals(dbUser.getUserName())&&password.equals(dbUser.getUserPassword())){
                resultList = CommonResult.successReturn(username);
            }else {
                resultList = CommonResult.errorReturn(11,"账号或密码不正确");
            }
        }else {
            resultList = CommonResult.errorReturn(12,"用户不存在");
        }


        return resultList;
    }

    /**
     * 退出登录，一般退出后要重定向到某个页面
     *
     * @return
     */
    @RequestMapping("logout")
    @ResponseBody
    public void logout(HttpServletResponse res) {
        // TODO: 填写自己的逻辑
        // res.sendRedirect("/sso/logout");
    }
}

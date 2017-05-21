package com.hctek.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.hctek.dao.AlumniMessageMapper;
import com.hctek.dao.AnniversaryAnnouncementMapper;
import com.hctek.dao.AnniversaryDynamicMapper;
import com.hctek.dao.UserMapper;
import com.hctek.model.AlumniMessage;
import com.hctek.model.AnniversaryAnnouncement;
import com.hctek.model.AnniversaryDynamic;
import com.hctek.model.User;
import com.hctek.myImpl.CommonResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Azurs on 2017-01-25.
 */
@Controller
public class MainController {
    ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    //获得一个BEAN USER表操作对象
    UserMapper UserDao=ctx.getBean(UserMapper.class);


    /*
    主页数据装载
    全加载未优化
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        AlumniMessageMapper AlumniMessageDao=ctx.getBean(AlumniMessageMapper.class);
        List<AlumniMessage> AlumniMessageList=AlumniMessageDao.getAllAlumniMessage();
        modelMap.addAttribute("AlumniMessageList", AlumniMessageList);

        AnniversaryAnnouncementMapper AnniversaryAnnouncementDao=ctx.getBean(AnniversaryAnnouncementMapper.class);
        List<AnniversaryAnnouncement> AnniversaryAnnouncementList=AnniversaryAnnouncementDao.getAllAnniversaryAnnouncement();
        modelMap.addAttribute("AnniversaryAnnouncementList", AnniversaryAnnouncementList);

        AnniversaryDynamicMapper AnniversaryDynamicDao=ctx.getBean(AnniversaryDynamicMapper.class);
        List<AnniversaryDynamic> AnniversaryDynamicList=AnniversaryDynamicDao.getAllAnniversaryDynamic();
        modelMap.addAttribute("AnniversaryDynamicList", AnniversaryDynamicList);


        return "index";
    }



    /*
    * 校园寄语
    * 单条获取显示
    * */
    @RequestMapping(value = "/alumni-message", method = RequestMethod.GET)
    public String AlumniMessageDetail(@RequestParam("id") Integer id,@RequestParam("code") String code,ModelMap modelMap) {
        AlumniMessageMapper AlumniMessageDao=ctx.getBean(AlumniMessageMapper.class);
        modelMap.addAttribute("AlumniMessage", AlumniMessageDao.selectByPrimaryKeyCode(id,code));

        return "alumni-message";
    }

    /*
    * 校园寄语
    * 页面列表显示
    * */
    @RequestMapping(value = "/alumni-messagelist", method = RequestMethod.GET)
    public String AlumniMessageList(@RequestParam("page") Integer page,ModelMap modelMap) {
        AlumniMessageMapper AlumniMessageDao=ctx.getBean(AlumniMessageMapper.class);


        return "alumni-messagelist";
    }

    /*
    * 校园公告
    * 单条获取显示
    * */
    @RequestMapping(value = "/anniversary-announcement", method = RequestMethod.GET)
    public String AnniversaryAnnouncementDetail(@RequestParam("id") Integer id,@RequestParam("code") String code,ModelMap modelMap) {
        AnniversaryAnnouncementMapper AnniversaryAnnouncementDao=ctx.getBean(AnniversaryAnnouncementMapper.class);
        modelMap.addAttribute("AnniversaryAnnouncement", AnniversaryAnnouncementDao.selectByPrimaryKeyCode(id,code));

        return "anniversary-announcement";
    }

    /*
    * 校园公告
    *  页面列表显示
    * */
    @RequestMapping(value = "/anniversary-announcementlist", method = RequestMethod.GET)
    public String AnniversaryAnnouncementList(@RequestParam("page") Integer page,ModelMap modelMap) {
        AnniversaryAnnouncementMapper AnniversaryAnnouncementDao=ctx.getBean(AnniversaryAnnouncementMapper.class);
        PageHelper.startPage(page, 10);
        List<AnniversaryAnnouncement> AnniversaryAnnouncementList=AnniversaryAnnouncementDao.getAllAnniversaryAnnouncement();
        modelMap.addAttribute("AnniversaryAnnouncementList", AnniversaryAnnouncementList);

        PageInfo pageinfo = new PageInfo(AnniversaryAnnouncementList);
        long count = pageinfo.getTotal();
        modelMap.addAttribute("PageInfo", pageinfo);

        return "anniversary-announcementlist";
    }

    /*
    * 校园动态
    * 单条获取显示
    * */
    @RequestMapping(value = "/anniversary-dynamic", method = RequestMethod.GET)
    public String AnniversaryDynamicDetail(@RequestParam("id") Integer id,@RequestParam("code") String code,ModelMap modelMap) {
        AnniversaryDynamicMapper AnniversaryDynamicDao=ctx.getBean(AnniversaryDynamicMapper.class);
        modelMap.addAttribute("AnniversaryDynamic", AnniversaryDynamicDao.selectByPrimaryKeyCode(id,code));

        return "anniversary-dynamic";
    }

    /*
    * 校园动态
    *  页面列表显示
    * */
    @RequestMapping(value = "/anniversary-dynamiclist", method = RequestMethod.GET)
    public String AnniversaryDynamicList(@RequestParam("page") Integer page,ModelMap modelMap) {
        AnniversaryDynamicMapper AnniversaryDynamicDao=ctx.getBean(AnniversaryDynamicMapper.class);


        return "anniversary-dynamiclist";
    }

    /*
    后台管理主页面
     */
    @RequestMapping(value = "/admin/myCMS", method = RequestMethod.GET)
    public String article() {


        return "admin/myCMS";
    }

    /*
    后台登录页面
     */
    @RequestMapping(value = "/admin/Login", method = RequestMethod.GET)
    public String userLogin() {


        return "admin/Login";
    }

    /*
    后台登录动作验证
     */
    @ResponseBody
    @RequestMapping(value = "/admin/Logining", method = RequestMethod.POST)
    public String Logining(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        User user = UserDao.userLogin(userName,passWord);

        Gson gson = new Gson();
        if ( user != null ) {
            return gson.toJson(CommonResult.successReturn(null, 0, "登录成功"));
        } else {
            return gson.toJson(CommonResult.successReturn(null, 1, "登录失败"));
        }


    }


    /*
    * 以下是后台里面的用户管理相关
    * */
    @ResponseBody
    @RequestMapping("/admin/usersjs")
    public List<User> getUsersjs(ModelMap modelMap) {
        // 查询user表中所有记录
        //初始化容器
        List<User> UserList=UserDao.getAllUsers();
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        //modelMap.addAttribute("userList", UserList);
        // 返回pages目录下的admin/users.jsp页面
        // return "admin/users";
        User user = UserDao.selectByPrimaryKey(1);

        return  UserList;
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {
        // 查询user表中所有记录
        //初始化容器
        List<User> UserList=UserDao.getAllUsers();
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        modelMap.addAttribute("userList", UserList);

        // 返回pages目录下的admin/users.jsp页面
        return "admin/users";
    }

    // get请求，访问添加用户 页面
    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        // 转到 admin/addUser.jsp页面
        return "admin/addUser";
    }

    // post请求，处理添加用户请求，并重定向到用户管理页面
    @ResponseBody
    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public Map<String,String>  addUserPost(@ModelAttribute("user") User userEntity) throws UnsupportedEncodingException {
        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象
        //@ModelAttribute注解：收集post过来的数据（在此，相当于post过来了一整个userEntity，不用一个一个地取）

        // 数据库中添加一个用户，该步暂时不会刷新缓存
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        userEntity.setCreatTime(df.format(new Date()));

        userEntity.setName(java.net.URLDecoder.decode(userEntity.getName(), "UTF-8")) ;
        userEntity.setPassword(java.net.URLDecoder.decode(userEntity.getPassword(), "UTF-8"));
        UserDao.insert(userEntity);

        Map<String,String> result = new HashMap<String,String>();
        result.put("flag", "true");

        // 重定向到用户管理页面，方法为 redirect:url
        return result;
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

        return "admin/users";
    }

    // 删除用户
    @ResponseBody
    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {

        // 删除id为userId的用户
        if (userId != 1) {
            UserDao.deleteByPrimaryKey(userId);
        }

//        Map<String,boolean> result = new HashMap<String,boolean>();
//        result.put("flag", true);
        Gson gson = new Gson();
        boolean flag = true;
        return gson.toJson(flag);
    }
 /**/
}

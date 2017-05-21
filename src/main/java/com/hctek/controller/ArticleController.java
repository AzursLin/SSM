package com.hctek.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baidu.ueditor.ActionEnter;
import com.google.gson.Gson;
import com.hctek.dao.AlumniMessageMapper;
import com.hctek.dao.AnniversaryAnnouncementMapper;
import com.hctek.dao.AnniversaryDynamicMapper;
import com.hctek.dao.UserMapper;
import com.hctek.model.*;
import com.hctek.myImpl.CommonResult;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Azurs on 2017-01-25.
 * 文章
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    /*寄语列表
    * */
    @RequestMapping(value = "message", method = RequestMethod.GET)
    public String message(ModelMap modelMap) {
        AlumniMessageMapper AlumniMessageDao=ctx.getBean(AlumniMessageMapper.class);
        List<AlumniMessage> AlumniMessageList=AlumniMessageDao.getAllAlumniMessage();
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        modelMap.addAttribute("List", AlumniMessageList);
        return "article/AlumniMessage";
    }


    /*寄语修改
    * */
    @ResponseBody
    @RequestMapping(value = "message/update/{id}", method = RequestMethod.GET)
    public String updateMessage(@PathVariable("id") Integer userId) {
        AlumniMessageMapper AlumniMessageDao=ctx.getBean(AlumniMessageMapper.class);
        AlumniMessage AlumniMessage= new AlumniMessage();
        AlumniMessage = AlumniMessageDao.selectByPrimaryKey(userId);
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        Gson gson = new Gson();
        return gson.toJson(AlumniMessage);
//        return "article/updateAlumniMessage";
    }

    /*公告列表
    * */
    @RequestMapping(value = "announcement", method = RequestMethod.GET)
    public String announcement(ModelMap modelMap) {
        AnniversaryAnnouncementMapper AnniversaryAnnouncementDao=ctx.getBean(AnniversaryAnnouncementMapper.class);
        List<AnniversaryAnnouncement> AnniversaryAnnouncementList=AnniversaryAnnouncementDao.getAllAnniversaryAnnouncement();
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        modelMap.addAttribute("List", AnniversaryAnnouncementList);

        return "article/AnniversaryAnnouncement";
    }

    /*公告修改
    */
    @ResponseBody
    @RequestMapping(value = "announcement/update/{id}", method = RequestMethod.GET)
    public String updateAnnouncement(@PathVariable("id") Integer userId) {

        AnniversaryAnnouncementMapper AnniversaryAnnouncementDao=ctx.getBean(AnniversaryAnnouncementMapper.class);
        AnniversaryAnnouncement AnniversaryAnnouncement= new AnniversaryAnnouncement();
        AnniversaryAnnouncement = AnniversaryAnnouncementDao.selectByPrimaryKey(userId);
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        Gson gson = new Gson();
        return gson.toJson(AnniversaryAnnouncement);
//        return "article/updateAlumniMessage";
    }

    /*动态列表
    */
    @RequestMapping(value = "dynamic", method = RequestMethod.GET)
    public String dynamic(ModelMap modelMap) {
        AnniversaryDynamicMapper AnniversaryDynamicDao=ctx.getBean(AnniversaryDynamicMapper.class);
        List<AnniversaryDynamic> AnniversaryDynamicList=AnniversaryDynamicDao.getAllAnniversaryDynamic();
        // 将所有记录传递给要返回的jsp页面，放在userList当中
        modelMap.addAttribute("List", AnniversaryDynamicList);

        return "article/AnniversaryDynamic";
    }

    /*公告修改
  *
  */
    @ResponseBody
    @RequestMapping(value = "dynamic/update/{id}", method = RequestMethod.GET)
    public String updateDynamic(@PathVariable("id") Integer userId) {
        AnniversaryDynamicMapper AnniversaryDynamicDao=ctx.getBean(AnniversaryDynamicMapper.class);
        AnniversaryDynamic AnniversaryDynamic = new AnniversaryDynamic();
        AnniversaryDynamic = AnniversaryDynamicDao.selectByPrimaryKey(userId);

        Gson gson = new Gson();
        return gson.toJson(AnniversaryDynamic);
    }



    @ResponseBody
    @RequestMapping(value = "sumbit", method = RequestMethod.POST)
    public String sumbit(@ModelAttribute Article article,HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String type = request.getParameter("type");
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        int issucess = 0;
        String resultmsg = "";
        Gson gson = new Gson();

        if (action.equals("add")) {
            if ((title.equals("")) || (content.equals(""))) {
                resultmsg = "标题或内容不能为空";
                content = gson.toJson(CommonResult.errorReturn(issucess, resultmsg));

            } else if (id.equals("")) {
                switch (type) {
                    case "message":
                            AlumniMessageMapper AlumniMessageDao = ctx.getBean(AlumniMessageMapper.class);
                            AlumniMessage AlumniMessage = new AlumniMessage();
                            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
                            AlumniMessage.setCreatTime(df.format(new Date()));
                            AlumniMessage.setTitle(title);
                            AlumniMessage.setContent(content);
                            issucess = AlumniMessageDao.insert(AlumniMessage);
                        break;

                    case "announcement":
                        AnniversaryAnnouncementMapper AnniversaryAnnouncementDao=ctx.getBean(AnniversaryAnnouncementMapper.class);
                        AnniversaryAnnouncement AnniversaryAnnouncement= new AnniversaryAnnouncement();
                        SimpleDateFormat announcementdf = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
                        AnniversaryAnnouncement.setCreatTime(announcementdf.format(new Date()));
                        AnniversaryAnnouncement.setTitle(title);
                        AnniversaryAnnouncement.setContent(content);
                        issucess = AnniversaryAnnouncementDao.insert(AnniversaryAnnouncement);
                        break;

                    case "dynamic":
                        AnniversaryDynamicMapper AnniversaryDynamicDao=ctx.getBean(AnniversaryDynamicMapper.class);
                        AnniversaryDynamic AnniversaryDynamic = new AnniversaryDynamic();
                        SimpleDateFormat AnniversaryDynamicdf = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
                        AnniversaryDynamic.setCreatTime(AnniversaryDynamicdf.format(new Date()));
                        AnniversaryDynamic.setTitle(title);
                        AnniversaryDynamic.setContent(content);
                        issucess = AnniversaryDynamicDao.insert(AnniversaryDynamic);
                        break;
                }

            }
        }
        else if (action.equals("update")){
            if ((title.equals("")) || (content.equals(""))) {
                resultmsg = "标题或内容不能为空";
                content = gson.toJson(CommonResult.errorReturn(issucess, resultmsg));

            } else if (!(id.equals(""))) {
                switch (type) {
                    case "message":
                            AlumniMessageMapper AlumniMessageDao = ctx.getBean(AlumniMessageMapper.class);
                            AlumniMessage AlumniMessage = new AlumniMessage();
                            AlumniMessage.setTitle(title);
                            AlumniMessage.setContent(content);
                            AlumniMessage.setId(Integer.parseInt(id));
                            issucess = AlumniMessageDao.updateByPrimaryKey(AlumniMessage);
                        break;
                    case "announcement":
                            AnniversaryAnnouncementMapper AnniversaryAnnouncementDao=ctx.getBean(AnniversaryAnnouncementMapper.class);
                            AnniversaryAnnouncement AnniversaryAnnouncement= new AnniversaryAnnouncement();
                            AnniversaryAnnouncement.setTitle(title);
                            AnniversaryAnnouncement.setContent(content);
                            AnniversaryAnnouncement.setId(Integer.parseInt(id));
                            issucess = AnniversaryAnnouncementDao.updateByPrimaryKey(AnniversaryAnnouncement);
                        break;
                    case "dynamic":
                            AnniversaryDynamicMapper AnniversaryDynamicDao=ctx.getBean(AnniversaryDynamicMapper.class);
                            AnniversaryDynamic AnniversaryDynamic = new AnniversaryDynamic();
                            AnniversaryDynamic.setTitle(title);
                            AnniversaryDynamic.setContent(content);
                            AnniversaryDynamic.setId(Integer.parseInt(id));
                            issucess = AnniversaryDynamicDao.updateByPrimaryKey(AnniversaryDynamic);
                        break;
                }

            }

        }
        else if ((action.equals("delete"))&&(!(id.equals("")))){
            switch (type) {
                case "message":
                        AlumniMessageMapper AlumniMessageDao = ctx.getBean(AlumniMessageMapper.class);
                        issucess = AlumniMessageDao.deleteByPrimaryKey(Integer.parseInt(id));
                    break;

                case "announcement":
                        AnniversaryAnnouncementMapper AnniversaryAnnouncementDao=ctx.getBean(AnniversaryAnnouncementMapper.class);
                        issucess = AnniversaryAnnouncementDao.deleteByPrimaryKey(Integer.parseInt(id));
                    break;

                case "dynamic":
                        AnniversaryDynamicMapper AnniversaryDynamicDao=ctx.getBean(AnniversaryDynamicMapper.class);
                        issucess = AnniversaryDynamicDao.deleteByPrimaryKey(Integer.parseInt(id));
                    break;

            }
        }

        if (issucess == 1) {
            resultmsg = "操作成功";
            content = gson.toJson(CommonResult.successReturn(null, issucess, resultmsg));
        } else {
            resultmsg = "操作失败";
            content = gson.toJson(CommonResult.errorReturn(issucess, resultmsg));
        }

        return content;
    }


    /*
    * UEditor编辑器初始化请求
    * */
    @ResponseBody
    @RequestMapping(value = "controller")
    public String getcfg(HttpServletRequest request, HttpServletResponse response){

        try {
            String classPath = this.getClass().getResource("/").getPath();
            classPath = request.getSession().getServletContext().getRealPath("/");

            String exec = new ActionEnter(request,classPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
            return exec;
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }


        return null;
    }
}

package com.hctek.controller;

import java.util.List;

import com.hctek.dao.UserMapper;
import com.hctek.model.User;
import com.hctek.myImpl.CommonResult;
//import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.google.common.base.Preconditions.checkNotNull;
//import com.google.common.collect.Lists;

//import static com.google.common.base.Preconditions.*;

/**
 * 针对某个表的CRUD操作 <br/>
 * 注意这个类中的所有方法不能抛异常，即使出错也用CommonResult包装下返回错误信息
 *
 * @version 1.0
 * @author foolbeargm@gmail.com
 */
@Controller
@CrossOrigin
@RequestMapping("/api/testSms")
public class TestSmsController {
    ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    //获得一个BEAN USER表操作对象
    UserMapper UserDao=ctx.getBean(UserMapper.class);
    private final static Logger logger = LoggerFactory.getLogger(TestSmsController.class);

    /**
     * 查询/select
     *
     * @param user 封装查询条件
     * @return 符合查询条件的记录
     */
    @RequestMapping(value = "select", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<User>> select(@RequestBody User user) {
        try {
 //           checkNotNull(vo);
 //           List<TestSmsVO> result = Lists.newArrayList();
//            List<User> result = UserDao.getAllUsers();
            // TODO: 填写自己的逻辑
            List<User> result = UserDao.getPartInfoByUsers(user);
//            return CommonResult.successReturn(result, 10000);
            return CommonResult.successReturn(result, 10000);
        } catch (Exception e) {
            logger.error("select error", e);
            return CommonResult.errorReturn(100, "select error");
        }
    }



    /**
     * 新增一条数据/insert <br/>
     *
     * @param user 要插入的数据
     * @return 完整的数据记录，补充了主键的(如果有主键的话)
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<User> insert(@RequestBody User user) {
        try {
            checkNotNull(user);


            if(UserDao.insert(user) == 1) {
                return CommonResult.successReturn(user, null, "新增用户成功,用户名" + user.getUserName());
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            logger.error("insert error", e);
            return CommonResult.errorReturn(200, "新增失败");
        }
    }

    /**
     * 更新/update <br/>
     * 可以单条更新，也可以批量更新
     *
     * @param keys 要更新的记录，逗号分隔的主键
     * @param user 要更新哪些字段
     * @return 更新了几条记录
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @CrossOrigin
    @ResponseBody
    public CommonResult<Integer> update(@RequestParam("keys") Integer keys, @RequestBody User user) {
        try {
            checkNotNull(keys);
//            checkNotNull(vo);

            // 注意：主键可能是数字，也可能是字符串，要自己处理

            if(UserDao.updateByPrimaryKeySelective(user) == 1) {
                return CommonResult.successReturn(100);
            }
            else{
                throw new Exception();
            }
        } catch (Exception e) {
            logger.error("update error", e);
            return CommonResult.errorReturn(300, "修改失败");
        }
    }

    /**
     * 删除/delete <br/>
     * 可以单条删除，也能批量删除
     *
     * @param keys 要删除的记录，逗号分隔的主键
     * @return 删除了几条记录
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @CrossOrigin
    @ResponseBody
    public CommonResult<Integer> delete(@RequestParam("keys") String keys) {
        try {
             checkNotNull(keys);


            if(UserDao.deleteByPrimaryKey(Integer.valueOf(keys)) == 1) {
                return CommonResult.successReturn(99);
            }
            else{
                throw new Exception();
            }
        } catch (Exception e) {
            logger.error("delete error", e);
            return CommonResult.errorReturn(400, "删除失败");
        }

    }

    /**
     * 从某个文件导入数据 <br/>
     * 不限定文件的格式和处理逻辑，需要自己和运营约定
     *
     * @param file
     * @return 返回一个string提示信息，提示信息看运营的需求，一般要包括成功/失败的记录数

    @RequestMapping("import")
    @ResponseBody
    public CommonResult<String> importFile(MultipartFile file) {
        try {
            // 将上传的文件写到一个临时位置，为了防止文件名冲突，加上时间戳
            File tmpFile = new File(System.getProperty("java.io.tmpdir"), System.currentTimeMillis() + file.getOriginalFilename());
            logger.info("import: writing tmp file {}", tmpFile.getAbsolutePath());
            file.transferTo(tmpFile);

            // TODO: 处理tmpFile并导入数据

            // 最后删除这个临时文件
            logger.info("import: delete tmp file {}", tmpFile.getAbsolutePath());
            tmpFile.delete();

            return CommonResult.successReturn("导入成功XX条，导入失败YY条，导入失败的行：1,2,3");
        } catch (Exception e) {
            logger.error("import error", e);
            return CommonResult.errorReturn(500, "import error");
        }
    }*/

    /**
     * 将符合某个条件的所有记录导出成一个文件 <br/>
     * 同样不限定文件格式和处理逻辑，需要自己和运营约定
     *
     * @param res
     * @param q 其实是queryVO的json，封装查询条件，需要手动反序列化
     * @return

    @RequestMapping(value = "export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public void exportFile(HttpServletResponse res, String q) {
        try {
            JSONObject json = JSONObject.parseObject(checkNotNull(q));
            checkArgument(json.size() > 0, "empty query condition");

            // 注意这个方法是查询符合条件的所有记录，忽略vo中的page和pageSize
            TestSmsQueryVO vo = JSONObject.parseObject(q, TestSmsQueryVO.class);

            String fileName = "export.csv"; // 用户下载得到的文件名，暂时写死
            File tmpFile = new File(System.getProperty("java.io.tmpdir"), System.currentTimeMillis() + fileName);
            logger.info("export: writing tmp file {}", tmpFile.getAbsolutePath());
            // TODO: 根据QueryVO中的条件查询并将结果写入tmpFile

            // 返回下载请求，这段代码不是很优雅，以后要优化下
            res.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            InputStream in = new FileInputStream(tmpFile);
            ServletOutputStream out = res.getOutputStream();
            IOUtils.copy(in, out);
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);

            // 最后删除临时文件
            logger.info("export: delete tmp file {}", tmpFile.getAbsolutePath());
            tmpFile.delete();
        } catch (Exception e) {
            logger.error("export error", e);
            try {
                res.reset();
                res.setHeader("Content-Type", "text/plain;charset=utf-8");
                ServletOutputStream out = res.getOutputStream();
                out.write("导出失败，请联系管理员。\n".getBytes("utf-8"));
                out.write(("错误信息：" + e.getMessage()).getBytes("utf-8"));
                IOUtils.closeQuietly(out);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }*/

}

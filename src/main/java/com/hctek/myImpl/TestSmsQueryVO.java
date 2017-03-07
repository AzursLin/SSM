package com.hctek.myImpl;

import java.util.Date;
import java.util.List;

/**
 * QueryVO例子
 *
 * @version 1.0
 * @author foolbeargm@gmail.com
 */
public class TestSmsQueryVO {

    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userAdministrative;

    // 这两个要有默认值
    private Integer page = 1;
    private Integer pageSize = 50;
}

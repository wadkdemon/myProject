package cn.com.guimei.service;

import cn.com.guimei.pojo.Superuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * 登录
 * Date: 2019/1/3
 * Time: 12:02
 */
public interface AdminService {
    public Superuser login(Superuser superuser);
    Superuser showUserById(String id);
    int updateById(Superuser superuser);
    List<Superuser> showInfo(Superuser superuser);
  
}

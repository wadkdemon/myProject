package cn.com.guimei.dao;

import cn.com.guimei.pojo.Customer;
import cn.com.guimei.pojo.Superuser;

import java.util.List;

public interface AdminMapper {
    //登录
    public Superuser login(Superuser superuser);
    //通过ID显示信息
    public Superuser showUserById(String id);
    //通过ID修改管理员账号
    int updateById(Superuser superuser);
    //显示管理员账号
    List<Superuser> showInfo(Superuser superuser);
    
}

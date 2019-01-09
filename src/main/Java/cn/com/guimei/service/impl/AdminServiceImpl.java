package cn.com.guimei.service.impl;

import cn.com.guimei.dao.AdminMapper;
import cn.com.guimei.pojo.Superuser;
import cn.com.guimei.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/3
 * Time: 12:03
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
     private AdminMapper adminMapper;

    public Superuser login(Superuser superuser) {
        return adminMapper.login(superuser);
    }

    public Superuser showUserById(String id) {
        return adminMapper.showUserById(id);
    }

    public int updateById(Superuser superuser) {
        return adminMapper.updateById(superuser);
    }

    public List<Superuser> showInfo(Superuser superuser) {
        return adminMapper.showInfo(superuser);
    }
}

package cn.com.guimei.controller;

import cn.com.guimei.pojo.Superuser;
import cn.com.guimei.service.impl.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/3
 * Time: 12:03
 */
@RequestMapping("/admin")
@Controller
public class AdminController {
    @Resource
    private AdminServiceImpl adminService;
    @RequestMapping("/login")
    public String login(Superuser user,HttpServletRequest request){
        Superuser superUser= adminService.login(user);
        if (superUser==null){
            request.setAttribute("error","您输入的账号有误！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/login.jsp";
        }
        request.getSession().setAttribute("superUser",superUser);
        return "index";
    }
    @RequestMapping("/showUserById")
    public String updateUserById(String id,HttpServletRequest request){
            Superuser superUser=adminService.showUserById(id);
            request.getSession().setAttribute("superUser",superUser);
//        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"superUserShowById";
       return "superUserShowInfo";
    }
    @RequestMapping("/superUserShowById")
    public String superUserShowById(Superuser superUser,HttpServletRequest request){
        List<Superuser> user=adminService.showInfo(superUser);
        if (user==null){
            request.setAttribute("error","信息有误！");
        }
        request.getSession().setAttribute("superUser",user);
        return "superUserShowInfo";
    }

    @RequestMapping("/updateById")
    public String updateById(){
        return "updateSuperUser";
    }
    @RequestMapping("/updateSuperUser")
    public String updateSuperUser(Superuser superuser,HttpServletRequest request){
           int user=adminService.updateById(superuser);
            if (user==0){
                request.setAttribute("error","修改失败！");
                return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/index.jsp";
            }
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/updateSuperUser.jsp";
    }

    //查询所有顾客
    @RequestMapping("/userListShowInfo")
    public String userListShowInfo(){

        return "showCustomer.jsp";
    }
}

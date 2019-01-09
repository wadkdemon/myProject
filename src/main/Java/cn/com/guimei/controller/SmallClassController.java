package cn.com.guimei.controller;

import cn.com.guimei.pojo.Page;
import cn.com.guimei.pojo.Smallclass;
import cn.com.guimei.service.SmallClassService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/7
 * Time: 22:49
 */
@Controller
@RequestMapping("/smallClass")
public class SmallClassController {
    @Resource
    SmallClassService smallClassService;
    @RequestMapping("/showInfo")
    public String unionShowInfo(Smallclass smallclass, String currentPage, HttpServletRequest request){
        Page<Smallclass> page=smallClassService.getSmallClassList(currentPage,smallclass);
        request.setAttribute("Map",page);
        return "showSmallClass";
    }

    @RequestMapping("/queryById")
     public String queryById(String id,HttpServletRequest request){
        Smallclass smallclass=smallClassService.queryById(id);
        if (smallclass==null){
            request.setAttribute("error","查询错误！");
            return "/smallClass/showInfo";
        }
        request.setAttribute("smallClass",smallclass);
        return "UpdateSmallClass";
    }
    @RequestMapping("/delById")
    public String delById(String id,HttpServletRequest request){
        int n=smallClassService.delById(id);
        if (n==0){
            request.setAttribute("error","删除错误！");
        }
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/smallClass/showInfo";
    }
    @RequestMapping("/updateById")
    public String updateById(Smallclass smallclass,HttpServletRequest request){
        int n=smallClassService.updateById(smallclass);
        if (n==0){
            request.setAttribute("error","修改失败！");
        }
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/smallClass/showInfo";
    }

    //查询商品类里的小分类
    @RequestMapping(value = "/ajaxQuery",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String ajaxQuery(){
        List<Smallclass> smallClass=smallClassService.ajaxQuery();
        return JSONArray.toJSONString(smallClass);
    }
}

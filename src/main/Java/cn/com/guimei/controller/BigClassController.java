package cn.com.guimei.controller;

import cn.com.guimei.pojo.Bigclass;
import cn.com.guimei.service.BigClassService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/6
 * Time: 22:46
 */
@Controller
@RequestMapping("/bigClass")
public class BigClassController {
    @Resource
    private BigClassService bigClassService;

    @RequestMapping("/showInfo")
    public String bigClassShowInfo(String currentPage, HttpServletRequest request){
        Map<String,Object> map=bigClassService.getBigClassList(currentPage);
        map.put("url","/bigClass/showInfo?currentPage=");
        request.setAttribute("Map",map);
        return "showBigClass";
    }

    @RequestMapping("del")
    public String deleteById(String id,HttpServletRequest request){
        int n=bigClassService.deleteById(id);
        if (n==0){
            request.setAttribute("error","删除失败！");
        }
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/bigClass/showInfo";
    }

    @RequestMapping("updateById")
    public String updateById(String id,HttpServletRequest request){
        Bigclass bigclass=bigClassService.updateById(id);
        if (bigclass==null){
            request.setAttribute("error","获取失败！");
        }else {
            request.setAttribute("Map",bigclass);
        }
        System.out.println(bigclass);

        return "UpdateBigClass";
    }

    @RequestMapping("updateInfo")
    public String updateInfo(Bigclass bigclass,HttpServletRequest request){
        int n=bigClassService.updateBigClass(bigclass);
        if (n==0){
            request.setAttribute("error","修改失败！");
        }
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/bigClass/showInfo";
    }

    @RequestMapping(value = "/ajaxQuery",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String ajaxQuery(){
        List<Bigclass> bigclass=bigClassService.ajaxQuery();
        return JSONArray.toJSONString(bigclass);
    }
}

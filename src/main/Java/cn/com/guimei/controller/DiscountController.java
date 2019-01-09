package cn.com.guimei.controller;

import cn.com.guimei.pojo.Discount;
import cn.com.guimei.service.DiscountService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/8
 * Time: 22:37
 */
@Controller
@RequestMapping("/discount")
public class DiscountController {
    @Resource
    private DiscountService discountService;
    @RequestMapping(value = "/ajaxQuery",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String ajaxQuery(){
        List<Discount> discounts=discountService.queryDiscountAll();
        return JSONArray.toJSONString(discounts);
    }
}

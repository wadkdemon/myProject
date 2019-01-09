package cn.com.guimei.controller;

import cn.com.guimei.pojo.Customer;
import cn.com.guimei.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/5
 * Time: 21:43
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @RequestMapping("/showInfo")
    public String customerShowInfo(String currentPage,HttpServletRequest request) {
        Map<String,Object> map=customerService.customerList(currentPage);

        //以键值对的形式将url放进request域里面
        map.put("url","/customer/showInfo?currentPage=");
        request.setAttribute("Map",map);
        return "showCustomer";
    }

    @RequestMapping("/unionShowInfo")
    public String unionCustomerShowInfo(Customer customer,String currentPage, HttpServletRequest request)  {
        System.out.println("=================="+customer.getId());
        //从前端获取条件，进入sql语句判断，当前端数据为空的时候，则写入空值判断条件。前端数据为String类型
        String cusId=customer.getId()==null? "0":customer.getId().toString();
        System.out.println("*****************************");
        System.out.println(cusId);
        System.out.println("*****************************");
        if(customer.getCusName()==null){
            customer.setCusName("");
        }
        if(customer.getCusSex()==null){
            customer.setCusSex("");
        }
//        customer.setId(Long.parseLong(cusId));
        Map<String,Object> map=customerService.unionCustomerList(currentPage,customer);

//        String cusName=customer==null?"0":customer.getCusName();
//        String cusSex=customer==null?"0":customer.getCusSex();
        map.put("url","/customer/getGoodsList?id="+cusId+"&cusName="+customer.getCusName()+"&cusSex="+customer.getCusSex()+"&currentPage=");
        request.setAttribute("Map",map);
        return "showCustomer";
    }

    @RequestMapping("/delete")
    public String deleteCustomer(String cusId,HttpServletRequest request){
        int n=customerService.deleteById(cusId);
        if (n==0){
            request.setAttribute("error","删除失败！");
        }
        //重定向到"/showInfo"
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/customer/showInfo";
    }

    @RequestMapping("/updateById")
    public String updateById(String cusId,HttpServletRequest request){
        Customer cus =customerService.updateById(cusId);
        if (cus ==null){
            request.setAttribute("error","数据传输错误！");
        }
        request.setAttribute("cus", cus);
        System.out.println("+++++++++++++++++");
        System.out.println(cus);
        System.out.println("+++++++++++++++++");
        return "updateCusInfo";
    }
    @RequestMapping("/update")
    public String updateById(Customer customer,HttpServletRequest request ){
        System.out.println("+++++++++++++++++");
        System.out.println(customer);
        System.out.println("+++++++++++++++++");
        int n=customerService.updateCustomer(customer);
        if (n==0){
            request.setAttribute("error","修改失败！");
        }else {
            request.setAttribute("customer",customer);
        }
        //重定向到"/showInfo"
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/customer/showInfo";
    }


}

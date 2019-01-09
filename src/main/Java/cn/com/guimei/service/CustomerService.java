package cn.com.guimei.service;

import cn.com.guimei.pojo.Customer;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/5
 * Time: 20:21
 */
public interface CustomerService {
    //查询当前页的顾客信息
    Map<String,Object> customerList(String  currentPage);
    //查询带条件的顾客信息
    Map<String,Object> unionCustomerList(String currentPage,Customer customer);
    //删除顾客信息
    int deleteById(String cusId);
    //根据id获取要修改的顾客信息
    Customer updateById(String cusId);
    //修改顾客信息
    int updateCustomer(Customer customer);
    //增加顾客信息
    int addCustomer(Customer customer);
}

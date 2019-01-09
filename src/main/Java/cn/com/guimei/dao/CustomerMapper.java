package cn.com.guimei.dao;

import cn.com.guimei.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/5
 * Time: 20:20
 */
public interface CustomerMapper {
    //获取总顾客信息条数
    int totalPage();
    //获取带条件查询的顾客信息条数
    int totalWherePage(Customer customer);
    //查询当前页的顾客信息
    List<Customer> customerList(@Param("currentPage") int currentPage,@Param("pageSize") int pageSize);
    //查询模糊的顾客信息
    List<Customer> customerWhereList(Map map);
    //删除顾客信息
    int deleteById(String cusId);
    //根据id获取要修改的顾客信息
    Customer updateById(String cusId);
    //修改顾客信息
    int updateCustomer(Customer customer);
    //增加顾客信息
    int addCustomer(Customer customer);

}

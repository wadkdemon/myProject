package cn.com.guimei.service.impl;

import cn.com.guimei.dao.CustomerMapper;
import cn.com.guimei.pojo.Customer;
import cn.com.guimei.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/5
 * Time: 20:22
 */
@Service
public class CustmerServiceImpl implements CustomerService {
    @Resource
    CustomerMapper customerMapper;
    //查询当前页的顾客信息
    public Map<String, Object> customerList(String cPage) {
        Map<String,Object> customerMap=new HashMap<String, Object>();
        //默认当前页为第一页
        int currentPage=1;
        //设置每页的数量
        int pageSize=4;
        //传进来的参数转换成int类型
        if (cPage != null && cPage.length()>0) {
            currentPage=Integer.parseInt(cPage);
        }
        //获取顾客的总条数
        int totalSize=customerMapper.totalPage();
        //计算总页数（总条数除以每页显示的数量，如果不等于就加1，等于0不加1）
        int totalPage=totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
        //显示当前页的信息
        int pageIndex=(currentPage-1)*pageSize;
        List<Customer> customerList=customerMapper.customerList(pageIndex,pageSize);
        //将总页数,当前页，当前页的信息放入Map集合
        customerMap.put("currentPage",currentPage);
        customerMap.put("totalPage",totalPage);
        customerMap.put("pageData",customerList);
        return customerMap;
    }
    //查询带条件的顾客信息
    public Map<String, Object> unionCustomerList(String cPage, Customer customer) {
        Map<String,Object> customerMap=new HashMap<String, Object>();
        //默认当前页为第一页
        int currentPage=1;
        //设置每页的数量
        int pageSize=4;
        //传进来的参数转换成int类型
        if (cPage != null && cPage.trim().length()>0) {
            currentPage=Integer.parseInt(cPage.trim());
        }
        //获取顾客的总条数
        int totalSize=customerMapper.totalWherePage(customer);
        //计算总页数（总条数除以每页显示的数量，如果不等于就加1，等于0不加1）
        int totalPage=totalSize%pageSize==0? totalSize/pageSize:totalSize/pageSize+1;
        //1.1 计算limit从多少开始
        int pageIndex=(currentPage-1)*pageSize;
        //1.2 新建一个Map集合，将查询的条件放入集合
        Map<String,Object> cMap=new HashMap<String, Object>();
        cMap.put("pageIndex",pageIndex);
        cMap.put("pageSize",pageSize);
        cMap.put("customer",customer);
        //再将查询条件放入模糊查询方法里面
        List<Customer> customerList=customerMapper.customerWhereList(cMap);
        //将总页数,当前页，当前页的信息放入Map集合
        customerMap.put("currentPage",currentPage);
        customerMap.put("totalPage",totalPage);
        customerMap.put("pageData",customerList);
        return customerMap;
    }

    public int deleteById(String cusId) {
        int n=customerMapper.deleteById(cusId);
        return n;
    }

    public Customer updateById(String cusId) {
        Customer customer=customerMapper.updateById(cusId);
        return customer;
    }

    public int updateCustomer(Customer customer) {
        int n=customerMapper.updateCustomer(customer);
        return n;
    }

    public int addCustomer(Customer customer) {
        return 0;
    }
}

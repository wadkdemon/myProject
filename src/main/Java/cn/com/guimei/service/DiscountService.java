package cn.com.guimei.service;

import cn.com.guimei.pojo.Discount;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/8
 * Time: 22:30
 */
public interface DiscountService {
    //查询所有
    List<Discount> queryDiscountAll();
}

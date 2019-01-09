package cn.com.guimei.dao;

import cn.com.guimei.pojo.Discount;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/8
 * Time: 22:27
 */
public interface DiscountMapper {
    //查询所有
    List<Discount> queryDiscountAll();
}

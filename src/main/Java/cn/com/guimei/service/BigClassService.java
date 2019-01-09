package cn.com.guimei.service;

import cn.com.guimei.pojo.Bigclass;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/6
 * Time: 23:10
 */
public interface BigClassService {
    //查询当前页的信息
    Map<String,Object> getBigClassList(String currentPage);
    //删除信息
    int deleteById(String id);
    //根据ID获取要修改的信息
    Bigclass updateById(String id);
    //修改信息
    int updateBigClass(Bigclass bigclass);
    //ajax查询
    List<Bigclass> ajaxQuery();
}

package cn.com.guimei.dao;

import cn.com.guimei.pojo.Smallclass;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/8
 * Time: 9:01
 */
public interface SmallClassMapper {
    //查询
    List<Smallclass> getSmallClassList(Map<String,Object> map);
    //总信息条数
    int totalPageSize(Smallclass smallclass);
    //根据id查询
    Smallclass queryById(String id);
    int updateById(Smallclass smallclass);
    int delById(String id);
    List<Smallclass> ajaxQuery();
}

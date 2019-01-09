package cn.com.guimei.service;

import cn.com.guimei.pojo.Page;
import cn.com.guimei.pojo.Smallclass;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/8
 * Time: 9:45
 */
public interface SmallClassService {
    Page<Smallclass> getSmallClassList(String currentPage, Smallclass smallclass);
    Smallclass queryById(String id);
    int updateById(Smallclass smallclass);
    int delById(String id);
    List<Smallclass> ajaxQuery();
}

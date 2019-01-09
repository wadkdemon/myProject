package cn.com.guimei.dao;

import cn.com.guimei.pojo.Bigclass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/6
 * Time: 22:49
 * 大分类管理
 */
public interface BigClassMapper {
    //获取总信息条数
    int totalPageSize();
    //查询当前页信息
    List<Bigclass> getBigClassList(@Param("currentPage") int currentPage,@Param("pageSize") int pageSize);
    //删除信息
    int deleteById(String id);
    //根据ID获取要修改的信息
    Bigclass updateById(String id);
    //修改信息
    int updateBigClass(Bigclass bigclass);
    //ajax查询
    List<Bigclass> ajaxQuery();
}

package cn.com.guimei.dao;

import cn.com.guimei.pojo.Goods;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    //级联查询
    List<Goods> getGoodsList(Map<String, Object> map);
    //获取信息条数
    int getTotalSize(Goods goods);
    //ID查询
    Goods queryById(String id);
    //删除
    int delById(String id);
    //修改
    int updateById(Goods goods);
    //增加
    int addGoods(Goods goods);


}
package cn.com.guimei.service;

import cn.com.guimei.pojo.Goods;
import cn.com.guimei.pojo.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/7
 * Time: 16:06
 */
public interface GoodsService {
    //级联查询
    Page<Goods> goodsQuery(String currentPage,Goods goods);
    //增加 对象，文件，文件路径 3个属性
    int addGoodsInfo(Goods goods, MultipartFile goodsFile, String filePath);
    //删除
    int delGoodsById(String id);
    //修改
    int updateGoodsById(Goods goods);
    //id查询
    Goods queryByID(String id);

}

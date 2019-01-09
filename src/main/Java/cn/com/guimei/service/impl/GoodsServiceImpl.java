package cn.com.guimei.service.impl;

import cn.com.guimei.dao.GoodsMapper;
import cn.com.guimei.pojo.Goods;
import cn.com.guimei.pojo.Page;
import cn.com.guimei.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/7
 * Time: 16:10
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    public Page<Goods> goodsQuery(String pageName, Goods goods) {
        int currentPage=1;
        int pageSize=5;
        if (pageName!=null&&pageName.length()>0){
            currentPage=Integer.parseInt(pageName);
        }
        int pageIndex=(currentPage-1)*pageSize;
        Map<String,Object>map=new HashMap<String, Object>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        map.put("goods",goods);
        Page<Goods> Map =new Page<Goods>();
        Map.setCurrentPage(currentPage);
        Map.setPageSize(pageSize);
        Map.setTotalRecode(goodsMapper.getTotalSize(goods));
        Map.setPageData(goodsMapper.getGoodsList(map));//!!!!!!!!!!!!!!!!!
        return Map;
    }

    //增加
    public int addGoodsInfo(Goods goods, MultipartFile goodsFile, String filePath) {
        //1、先判断文件路径是否存在
        File file=new File(filePath);
        if (file.exists()){
            //2、获取文件名称
            String goodsImageName=goodsFile.getOriginalFilename();
            //3、获取文件大小
            // toLowerCase()使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
            /* endsWith
             * public boolean endsWith(String suffix)测试此字符串是否以指定的后缀结束。
            */
            long fileSize=goodsFile.getSize();
            if (goodsImageName.toLowerCase().endsWith(".gif")||
                goodsImageName.toLowerCase().endsWith(".bmp") ||
                goodsImageName.toLowerCase().endsWith(".jpeg") ||
                goodsImageName.toLowerCase().endsWith(".icon") ||
                goodsImageName.toLowerCase().endsWith(".jpg")
            ){
                //4、设置文件大小
                if (fileSize<=1024*1024*5){
                    try {
                        //5、执行写入操作
                        /*transferTo(long position, long count, WritableByteChannel target)
                        *将字节从此通道的文件传输到给定的可写入字节通道
                        *
                        * File(File parent, String child)
                        *根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
                        */
                        goodsFile.transferTo(new File(file,"/"+goodsImageName));
                        //6、执行数据库写入操作
                        goods.setGoodsImage(goodsImageName);
                        int n=goodsMapper.addGoods(goods);
                        if(n>0){
                            return 0;
                        }else {
                            //写入数据库失败
                            return 2;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    //图片过大
                    return 3;
                }
            }else {
                //图片类型不匹配
                return 4;
            }
        }
        //图片写入失败（文件路径不存在）
        return 1;
    }


    public int delGoodsById(String id) {
        return goodsMapper.delById(id);
    }

    public int updateGoodsById(Goods goods) {
        return goodsMapper.updateById(goods);
    }

    public Goods queryByID(String id) {
        return goodsMapper.queryById(id);
    }


}

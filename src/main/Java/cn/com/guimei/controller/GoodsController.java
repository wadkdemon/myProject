package cn.com.guimei.controller;

import cn.com.guimei.pojo.Goods;
import cn.com.guimei.pojo.Page;
import cn.com.guimei.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/7
 * Time: 15:00
 * 商品
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @RequestMapping("/getGoodsList")
    public String unionShowInfo(String currentPage, Goods goods, HttpServletRequest request){
        if (goods.getGoodsName()==null){
            goods.setGoodsName("");
        }
        Page<Goods> page=goodsService.goodsQuery(currentPage,goods);
        Long id=goods.getId()==null?0:goods.getId();
        String goodsName=goods.getGoodsName()==null?"":goods.getGoodsName();
        Long smalId=goods.getGoodsSmalId()==null?0:goods.getGoodsSmalId();
        page.setUrl("/goods/getGoodsList?id="+id+"&goodsName="+goodsName+"&smalId="+smalId+"&currentPage=");
        request.setAttribute("Map",page);
        return "showGoods";
    }
    @RequestMapping("/queryById")
    public String queryById(String id,HttpServletRequest request){
        Goods goods=goodsService.queryByID(id);
        if (goods==null){
            request.setAttribute("error","检索错误!");
        }else {
            request.setAttribute("goods",goods);
        }
        return "updateGoodsInfo";
    }
    @RequestMapping("/delById")
    public String delById(String id,HttpServletRequest request){
        int n=goodsService.delGoodsById(id);
        if (n==0){
            request.setAttribute("error","删除失败");
        }
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/goods/getGoodsList";
    }
    @RequestMapping("/updateById")
    public String updateById(Goods goods,HttpServletRequest request){
        int n=goodsService.updateGoodsById(goods);
        if (n==0){
            request.setAttribute("error","修改失败！");
        }
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/goods/getGoodsList";
    }

    @RequestMapping("/localAddGoods")
    public String localAddGoods(){
        return "addGoodsInfo";
    }
    @RequestMapping("/addGoods")
    public String addGoods(Goods goods, MultipartFile goodsImages,HttpServletRequest request){
        //设置路径
        String filePath=request.getRealPath("/static/images/goodsImage");
        //进行判断
        int i=goodsService.addGoodsInfo(goods,goodsImages,filePath);
        if(i==1){
            request.setAttribute("error","图像文件路径不存在！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }else if(i==2){
            request.setAttribute("error","添加商品失败！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }else if(i==3){
            request.setAttribute("error","上传文件不能操作5MB！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }else if(i==4){
            request.setAttribute("error","文件类型非要求的图像格式！");
            return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/WEB-INF/page/addGoods.jsp";
        }
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+"/goods/getGoodsList";
    }

}

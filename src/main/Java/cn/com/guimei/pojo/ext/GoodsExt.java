package cn.com.guimei.pojo.ext;

import cn.com.guimei.pojo.Discount;
import cn.com.guimei.pojo.Goods;
import cn.com.guimei.pojo.Smallclass;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/7
 * Time: 15:07
 */
public class GoodsExt extends Goods {
    private Smallclass smallClass;
    private Discount discount;

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Smallclass getSmallClass() {
        return smallClass;
    }

    public void setSmallClass(Smallclass smallClass) {
        this.smallClass = smallClass;
    }
}

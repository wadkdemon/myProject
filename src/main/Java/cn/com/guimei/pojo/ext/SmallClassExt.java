package cn.com.guimei.pojo.ext;

import cn.com.guimei.pojo.Bigclass;
import cn.com.guimei.pojo.Smallclass;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/8
 * Time: 9:54
 */
public class SmallClassExt extends Smallclass {
    private Bigclass bigClass;

    public Bigclass getBigClass() {
        return bigClass;
    }

    public void setBigClass(Bigclass bigClass) {
        this.bigClass = bigClass;
    }

    @Override
    public String toString() {
        return "SmallClassExt{" +
                "bigClass=" + bigClass +
                '}';
    }
}

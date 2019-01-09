package cn.com.guimei.service.impl;

import cn.com.guimei.dao.BigClassMapper;
import cn.com.guimei.pojo.Bigclass;
import cn.com.guimei.service.BigClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/6
 * Time: 23:12
 */
@Service
public class BigClassServiceImpl implements BigClassService {
    @Resource
    private BigClassMapper bigClassMapper;
    public Map<String, Object> getBigClassList(String pageName) {
        Map<String,Object>map=new HashMap<String, Object>();
        int currentPage =1;
        int pageSize=5;
        if (pageName !=null&& pageName !=""){
            currentPage =Integer.parseInt(pageName);
        }
        int totalSize=bigClassMapper.totalPageSize();
        int totalPage=totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
        int pageIndex=(currentPage -1)*pageSize;
        List<Bigclass>bigClassList=bigClassMapper.getBigClassList(pageIndex,pageSize);
        map.put("currentPage", currentPage);
        map.put("totalPage",totalPage);
        map.put("bigClassList",bigClassList);
        return map;
    }

    public int deleteById(String id) {
        return bigClassMapper.deleteById(id);
    }

    public Bigclass updateById(String id) {
        return bigClassMapper.updateById(id);
    }

    public int updateBigClass(Bigclass bigclass) {
        return bigClassMapper.updateBigClass(bigclass);
    }

    public List<Bigclass> ajaxQuery() {
        return bigClassMapper.ajaxQuery();
    }
}

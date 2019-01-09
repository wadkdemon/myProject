package cn.com.guimei.service.impl;

import cn.com.guimei.dao.SmallClassMapper;
import cn.com.guimei.pojo.Page;
import cn.com.guimei.pojo.Smallclass;
import cn.com.guimei.service.SmallClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/1/8
 * Time: 9:49
 */
@Service
public class SmallClassServiceImpl implements SmallClassService {
    @Resource
    private SmallClassMapper smallClassMapper;

    public Page<Smallclass> getSmallClassList(String pageName, Smallclass smallclass) {
        int currentPage=1;
        int pageSize=5;
        if (pageName!=null&&pageName.length()>0){
            currentPage=Integer.parseInt(pageName);
        }
        int pageIndex=(currentPage-1)*pageSize;
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        map.put("smallClass",smallclass);
        Page<Smallclass> page=new Page<Smallclass>();
        Long id=smallclass.getId()==null||smallclass.getId()==0?0:smallclass.getId();
        Long smallBigId=smallclass.getSmallBigId()==null?0:smallclass.getSmallBigId();
        String smallName=smallclass.getSmallName()!=null&&smallclass.getSmallName().length()>0?smallclass.getSmallName():"";
        page.setUrl("/smallClass/showInfo?id="+id+"&smallName="+smallName+"&smallBigId="+smallBigId+"&currentPage=");
        page.setTotalRecode(smallClassMapper.totalPageSize(smallclass));
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        page.setPageData(smallClassMapper.getSmallClassList(map));
        return page;
    }

    public Smallclass queryById(String id) {
        return smallClassMapper.queryById(id);
    }

    public int updateById(Smallclass smallclass) {
        return smallClassMapper.updateById(smallclass);
    }

    public int delById(String id) {
        return smallClassMapper.delById(id);
    }

    public List<Smallclass> ajaxQuery() {
        return smallClassMapper.ajaxQuery();
    }


}

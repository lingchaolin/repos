package service.impl;

import com.github.pagehelper.PageInfo;
import dao.VenderMapper;
import model.Vender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IVenderService;
import util.DateUtil;

import java.util.List;
import java.util.Map;

@Service
public class VenderService implements IVenderService {

    @Autowired
    private VenderMapper venderMapper;


    @Override
    public void addVender(Vender vender) {
        vender.setVenderCode(DateUtil.getNum());
        vender.setCreateTime(DateUtil.getNow());
        venderMapper.addVender(vender);
    }

    @Override
    public PageInfo showVender(Map map) {

        List dataList = venderMapper.showVender(map, Integer.parseInt(map.get("pageNum").toString()),5);
        PageInfo page = new PageInfo(dataList);
        return page;
    }

}

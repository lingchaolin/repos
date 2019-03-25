package service;

import com.github.pagehelper.PageInfo;
import model.Vender;

import java.util.Map;

public interface IVenderService {

    void addVender(Vender vender);
    PageInfo showVender(Map map);
}

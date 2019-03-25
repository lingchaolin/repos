package dao;

import model.Vender;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VenderMapper {

    @Insert("insert into vender values(#{venderID},#{venderCode},#{venderType},#{venderName},#{address},#{telephone},#{contacts}" +
            ",#{productLicense},#{bussinessRegistrationNo},#{registeredCapital},#{userID},#{createTime},#{zxbj},#{remark})")
    void addVender(Vender vender);


    List<Vender> showVender(
            Map map,
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSize);
}

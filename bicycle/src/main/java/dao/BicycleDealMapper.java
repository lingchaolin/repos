package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import model.BicycleDeal;

public interface BicycleDealMapper {




	//添加车辆业务流水
    int addBicycleDeal(BicycleDeal bicycleDeal);
    
    //根据车桩id查询对应的业务流水
    @Select("select DEAL_ID dealId,DEAL_NAME dealName,DEAL_TYPE dealType from BICYCLE_DEAL where PILE_ID=#{pileId}")
    public List<BicycleDeal> selectBicycleDealByPileId(Integer pileId);
    
    //group by 流水表的type
    public List<Map> selectBicycleDealType(Integer stationId);
    

}

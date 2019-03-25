package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.*;
import model.BicycleDeal;
import model.BicycleInfo;
import model.BicycleRecord;
import model.Card_record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.IBicycleService;
import util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BicycleService implements IBicycleService {

    @Autowired
    private BicycleStationMapper bicycleStationMapper;
    @Autowired
    private BicyclePileMapper bicyclePileMapper;
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private BicycleInfoMapper bicycleInfoMapper;
    @Autowired
    private CardRecordMapper cardRecordMapper;
    @Autowired
    private BicycleRecordMapper bicycleRecordMapper;
    @Autowired
    private BicycleDealMapper bicycleDealMapper;
    @Autowired
    private BicycleStaMapper bicycleStaMapper;

    @Override
    public List showBicycleStation() {

        List bicycleList = bicycleStationMapper.showBicycleStation();

        return bicycleList;
    }


    @Override
    @Transactional
    public String rentBicycle(Map map){
        int cardId = (Integer) map.get("cardId");
        int pileId = (Integer) map.get("pileId");
        int userId = (int) map.get("userId");//创建人
        Integer cardRecordId = null;

        //检查是否可以租车
        if (bicyclePileMapper.hasbicycle(pileId) == 2) {
            return "车桩无车";
        }
        if (cardMapper.cardStatus(cardId) == 2){
            return "卡不可用";
        }
        if (cardMapper.cardMoney(cardId) < 200){
            return "卡余额不足";
        }
        if (bicycleInfoMapper.selectBicycleByCard(cardId) != null){
            return "卡已有租车";
        }

        //进行租车操作
        int bicycleId = bicyclePileMapper.selectBicycleIdByPileId(pileId);
        String time = DateUtil.getNow();
        String timeNum = DateUtil.getNum();
        //1.修改车辆状态
        bicycleInfoMapper.bicycleRented(bicycleId,cardId);
        //2.修改车辆车桩
        bicyclePileMapper.pileRented(pileId);
        //3.修改租车卡金额
        double frozenMoney = cardMapper.frozenMoney(cardId);
        if (frozenMoney < 200){
            cardMapper.changeFrozenMoney(cardId,200-frozenMoney);
            cardMapper.changeWalletMoney(cardId,frozenMoney-200);
            //新增卡费用流水
            Card_record card_record = new Card_record(null,cardId,5,0.0,frozenMoney-200,200-frozenMoney,time,userId,null,null);
            cardRecordMapper.addCardRecord(card_record);
        }
        //4.新增车辆租还记录
        BicycleRecord bicycleRecord = new BicycleRecord(null,bicycleId,cardId,time,pileId,null,null,null,null);
        cardRecordId = bicycleRecord.getRecordId();
        //5.新增车辆业务流水
        BicycleDeal bicycleDeal = new BicycleDeal(null,time,timeNum,"2",cardRecordId,cardId,"0",0.0,null,bicycleId,pileId,userId);
        bicycleDealMapper.addBicycleDeal(bicycleDeal);

        return "租车成功";

    }

    @Override
    @Transactional
    public String returnBicycle(Map map){
        int cardId = (Integer) map.get("cardId");
        int pileId = (Integer) map.get("pileId");
        int userId = (int) map.get("userId");//创建人
        Integer cardRecordId = null;
        String time = DateUtil.getNow();
        String timeNum = DateUtil.getNum();

        //校验是否可以还车
        if (bicycleInfoMapper.selectBicycleByCard(cardId) == null){
            return "卡没有租车";
        }
        if (bicyclePileMapper.hasbicycle(pileId) == 1) {
            return "车桩有车";
        }
        //查询卡内余额是否足够
        //获取租车时间
        int bicycleId = bicycleInfoMapper.selectBicycleByCard(cardId).getBicycleId();
        BicycleRecord bicycleRecord = bicycleRecordMapper.selectUncompletedRecord(bicycleId);
//        String rt = bicycleRecord.getRentTime();
//        String rtn = DateUtil.StringNowToNum(rt);
//        int rentTime = (int) Math.ceil((Double.parseDouble(timeNum) - Double.parseDouble(DateUtil.StringNowToNum(bicycleRecord.getRentTime()))/3600));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long nowTime = System.currentTimeMillis();
        Date rentT = null;
        try {
            rentT = sdf.parse(bicycleRecord.getRentTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int rentTime = (int) Math.ceil(((nowTime - rentT.getTime())/3600000.0));


        //计算租金
        int rentFee = 0;
        if (rentTime == 2){
            rentFee = 1;
        } else if (rentTime == 3) {
            rentFee = 3;
        } else if (rentTime > 3) {
            rentFee = 3 + (rentTime - 3) * 3;
        }

        if (cardMapper.walletMoney(cardId) - rentFee < 0) {
            return "卡内余额不足";
        }
        //还车操作
        //1.扣除租金
        cardMapper.changeWalletMoney(cardId,-rentFee);
        //2.新增卡费用流水
        Card_record card_record = new Card_record(null,cardId,2,0.0, (double) -rentFee,0.0,time,userId,null,null);
        cardRecordMapper.addCardRecord(card_record);
        //3.修改车辆信息表
        bicycleInfoMapper.bicycleReturned(bicycleId,pileId);
        //4.修改车桩表
        bicyclePileMapper.pileReturned(pileId,bicycleId);
        //5.修改车辆租还记录表
        cardRecordId = bicycleRecord.getRecordId();
        bicycleRecordMapper.returnBicycle(cardRecordId,(double)rentFee,pileId,time);
        //6.新增车辆业务流水
        BicycleDeal bicycleDeal;
        if (rentFee == 0){
            bicycleDeal = new BicycleDeal(null,time,timeNum,"3",cardRecordId,cardId,"0",0.0,null,bicycleId,pileId,userId);
        }else {
        bicycleDeal = new BicycleDeal(null,time,timeNum,"3",cardRecordId,cardId,"1",(double)rentFee,1,bicycleId,pileId,userId);
        }
        bicycleDealMapper.addBicycleDeal(bicycleDeal);

        return "还车成功";

    }

    @Override
    public Map bicycleSta(String startDay, String endDay) {
        Map bicycleSta= bicycleStaMapper.bicycleSta(startDay, endDay);
        return bicycleSta;
    }

    @Override
    public PageInfo allBicycleInfo(Map map){
        PageHelper.startPage(Integer.parseInt(map.get("pageNum").toString()), 5);
//        List<BicycleInfo> list = bicycleInfoMapper.allBicycleInfo(map, Integer.parseInt(map.get("pageNum").toString()),5);
        List<BicycleInfo> list = bicycleInfoMapper.allBicycleInfo(map);
        PageInfo page = new PageInfo(list);

        return page;
    }

    @Override
    public Map bicycleInfoSta(Integer bicycleId){
        Map bicycleInfoSta = bicycleStaMapper.bicycleInfoSta(bicycleId);
        return bicycleInfoSta;
    }

}
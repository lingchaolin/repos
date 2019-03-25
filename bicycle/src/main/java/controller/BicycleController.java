package controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IBicycleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BicycleController {

    @Autowired
    private IBicycleService bicycleService;

    @RequestMapping("/stationmap")
    @ResponseBody
    public String showStation(){
        List stationList = bicycleService.showBicycleStation();
        String json = JSON.toJSONString((stationList));
        System.out.print(json);
//        model.addAttribute("stationList",stationList);
        return json;
    }

    @RequestMapping(value="/rentBicycle",produces= {"text/plain;charset=utf-8"})
    @ResponseBody
    public String rentBicycle(Model model){
        Map map = new HashMap();
        map.put("cardId",1);
        map.put("pileId",1);
        map.put("userId",1);
        String result = bicycleService.rentBicycle(map);
        if ("租车成功".equals(result)){
            return "租车成功";
        }
        model.addAttribute("rentError", result);
        return result;

    }

    @RequestMapping(value="/returnBicycle",produces= {"text/plain;charset=utf-8"})
    @ResponseBody
    public String returnBicycle(Model model){
        Map map = new HashMap();
        map.put("cardId",1);
        map.put("pileId",1);
        map.put("userId",1);
        String result = bicycleService.returnBicycle(map);
        if ("还车成功".equals(result)){
            return "还车成功";
        }
        model.addAttribute("returnError", result);
        return result;

    }

    @RequestMapping("/bicyclesta")
    public String bicycleSta(){
        return "/WEB-INF/bicyclesta/bicyclesta.jsp";
    }

    @RequestMapping("/showbicyclesta")
    public String showBicycleSta(@RequestParam Map<String, Object> params, Model model) {

        Map bicycleSta = bicycleService.bicycleSta(params.get("startDay").toString(), params.get("endDay").toString());
        model.addAttribute("bicycleSta", bicycleSta);
        return "/WEB-INF/bicyclesta/bicyclestatable.jsp";

    }

    @RequestMapping("/allbicycle")
    public String allBicycle(){
        return "/WEB-INF/bicyclesta/allbicycle.jsp";
    }

    @RequestMapping("/showallbicycle")
    public String showAllBicycleInfo(@RequestParam Map<String, Object> params,Model model) {
//        List<BicycleInfo> list = bicycleService.allBicycleInfo((bicycleId==null)?null:Integer.parseInt(bicycleId));
        PageInfo page = bicycleService.allBicycleInfo(params);
        model.addAttribute("page", page);
        return "/WEB-INF/bicyclesta/allbicycletable.jsp";
    }

    @RequestMapping("/bicycleinfosta")
    public String bicycleInfoSta(){
        return "/WEB-INF/bicyclesta/bicycleinfosta.jsp";
    }

    @RequestMapping("/showbicycleinfosta")
    public String showBicycleInfoSta(String bicycleId,Model model){
        Map bicycleInfoSta = bicycleService.bicycleInfoSta(Integer.parseInt(bicycleId));
        model.addAttribute("bicycleInfoSta", bicycleInfoSta);
        return "/WEB-INF/bicyclesta/bicycleinfosta.jsp";
    }
}

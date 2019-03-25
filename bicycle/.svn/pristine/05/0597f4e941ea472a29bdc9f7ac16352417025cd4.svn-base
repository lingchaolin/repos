package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;

import model.Bicycle_station;
import service.IBicycle_StationService;

@Controller
public class Bicycle_stationController {
	@Autowired
	private IBicycle_StationService bicycle_StationService;

	@RequestMapping("/station")
	public void selectStation(HttpServletResponse response) throws IOException  {
		response.setContentType("text/plain;charset=utf-8");
		List<Bicycle_station> bList = bicycle_StationService.selectStation();
		StringBuffer sb = new StringBuffer();
		sb.append(JSONArray.toJSONString(bList));
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
		out.flush();
		out.close();
	}
}

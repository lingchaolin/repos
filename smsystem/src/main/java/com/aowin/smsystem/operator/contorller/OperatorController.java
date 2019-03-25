/**
 * 
 */
package com.aowin.smsystem.operator.contorller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aowin.smsystem.operator.dao.OperatorDAO;
import com.aowin.smsystem.operator.pojo.Operators;
/**
 * 操作员管理模块的处理类
 * @author Administrator
 *
 */
@Controller
public class OperatorController {
	/**
	 * 
	 */
	private Logger log=LogManager.getLogger(OperatorController.class);
	@Autowired
	private OperatorDAO operatordao;
	public OperatorController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 操作员添加链接请求
	 * @param m
	 * @return tiles name
	 */
	@RequestMapping(value="/addoperatorlink")
	public String addOperatorLink(Model m) {
		log.info("调用处理方法：addOperatorLink");
		m.addAttribute("titleinfo","新增操作员");
		return "newOperator";
	}
	/**
	 * 添加操作员的请求
	 * @param o
	 * @param result
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/addoperator",method=RequestMethod.POST)
	public String addOperator(@Valid Operators o,String[] operatorsex,String[] isadmin,BindingResult result,Model m) {
		log.info("调用处理方法: addOperator()");
		if("1".equals(operatorsex[0])) {
			o.setOperatorsex("1");
		}else {
			o.setOperatorsex("0");
		}
		if("Y".equals(isadmin[0])) {
			o.setIsadmin("Y");
		}else {
			o.setIsadmin("N");
		}
		m.addAttribute("titleinfo", "新增操作员");
		if(result.hasFieldErrors()){
			FieldError operatorname=result.getFieldError();
			if(operatorname!=null) {
				m.addAttribute("operatorname", operatorname.getDefaultMessage());
			}
			FieldError username=result.getFieldError();
			if(operatorname!=null) {
				m.addAttribute("username", username.getDefaultMessage());
			}
			FieldError userpwd=result.getFieldError();
			if(operatorname!=null) {
				m.addAttribute("userpwd", userpwd.getDefaultMessage());
			}
			o.setOperatorname(o.getOperatorname());
			o.setUsername(o.getUsername());
			o.setUserpwd(o.getUserpwd());
			m.addAttribute("operatorvalid", o);
			return "newOperator";
		}
		try {
			operatordao.insertOperator(o);
			m.addAttribute("operatorinfo", "操作员添加成功");
		} catch (Exception e) {
			log.warn("操作员添加失败："+e);
			m.addAttribute("operatorinfo", "操作员添加失败");
		}
		return "newOperator";
	}
	@RequestMapping(value="/showoperator")
	public String showOperator(Model m) {
		log.info("调用处理方法: showOperator()");
		m.addAttribute("titleinfo", "更新操作员");
		ArrayList<Operators> list=(ArrayList<Operators>) operatordao.getOperators(1,5);
		m.addAttribute("list", list);
		return "modifyOperator";
	}
	@RequestMapping(value="/modifyoperatorlink",method=RequestMethod.POST)
	public String modifyOperatorLink(Operators o,String[] operatorid,BindingResult result,Model m) {
		log.info("调用处理方法: modifyOperatorLink()");
		m.addAttribute("titleinfo", "修改操作员");
		log.info(operatorid);
		Operators operators = operatordao.getOperatorsById(o.getOperatorid());
		m.addAttribute("operators", operators);
		return "modOperator";
	}
	@RequestMapping(value="/modifyoperator",method=RequestMethod.POST)
	public String modifyOperator(@Valid Operators o,String[] operatorsex,String[] isadmin,BindingResult result,Model m) {
		log.info("调用处理方法: modifyoperator()");
		if("1".equals(operatorsex[0])) {
			o.setOperatorsex("1");
		}else {
			o.setOperatorsex("0");
		}
		if("Y".equals(isadmin[0])) {
			o.setIsadmin("Y");
		}else {
			o.setIsadmin("N");
		}
		m.addAttribute("titleinfo", "修改操作员");
		if(result.hasFieldErrors()){
			FieldError operatorname=result.getFieldError();
			if(operatorname!=null) {
				m.addAttribute("operatorname", operatorname.getDefaultMessage());
			}
			FieldError username=result.getFieldError();
			if(operatorname!=null) {
				m.addAttribute("username", username.getDefaultMessage());
			}
			FieldError userpwd=result.getFieldError();
			if(operatorname!=null) {
				m.addAttribute("userpwd", userpwd.getDefaultMessage());
			}
			o.setOperatorname(o.getOperatorname());
			o.setUsername(o.getUsername());
			o.setUserpwd(o.getUserpwd());
			m.addAttribute("operatorvalid", o);
			return "newOperator";
		}
		try {
			operatordao.updateOperators(o);
			m.addAttribute("operatorinfo", "操作员修改成功");
		} catch (Exception e) {
			log.warn("操作员添加失败："+e);
			m.addAttribute("operatorinfo", "操作员修改失败");
		}
//		 return "redirect:/hello";
//		 return "forward:/hello"; 
		   return "redirect:/showoperator"; 
	}
	@RequestMapping(value="/deleteOperator",method=RequestMethod.POST)
	public String deleteOperator(String[] operatorselectid,Model m) {
		log.info("调用处理方法: deleteOperator()");
		m.addAttribute("titleinfo", "删除操作员");
		int operatorid=Integer.parseInt(operatorselectid[0]);
		try {
			operatordao.deleteOperator(operatorid);
			m.addAttribute("operatorinfo", "删除操作员成功");
			System.out.println("operatorinfo");
		} catch (Exception e) {
			log.warn("删除操作员失败："+e);
			m.addAttribute("operatorinfo", "删除操作员失败");
		}
		return "redirect:/deletetoshow";
	}
	@RequestMapping(value="/deleteOperators",method=RequestMethod.POST)
	public String deleteOperators(String[] operatorselectid,Model m) {
		log.info("调用处理方法: deleteOperators()");
		m.addAttribute("titleinfo", "删除操作员");
		ArrayList<Integer> operatorids = new ArrayList<>();
		for(String id:operatorselectid) {
			operatorids.add(Integer.parseInt(id));
		}
		try {
			operatordao.deleteOperators(operatorids);
			m.addAttribute("operatorinfo", "删除操作员成功");
		} catch (Exception e) {
			log.warn("删除操作员失败："+e);
			m.addAttribute("operatorinfo", "删除操作员失败");
		}
		return "redirect:/deletetoshow";
	}
	@RequestMapping(value="/deletetoshow")
	public String deletetoshow(Model m,@RequestParam(value="operatorinfo",required=true)String operatorinfo) {
		log.info("调用处理方法: showOperator()");
		m.addAttribute("titleinfo", "更新操作员");
		ArrayList<Operators> list=(ArrayList<Operators>) operatordao.getOperators(1,5);
		m.addAttribute("operatorinfo",operatorinfo);
		m.addAttribute("list", list);
		return "modifyOperator";
	}
}

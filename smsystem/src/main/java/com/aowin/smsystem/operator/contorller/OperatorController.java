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
 * ����Ա����ģ��Ĵ�����
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
	 * ����Ա������������
	 * @param m
	 * @return tiles name
	 */
	@RequestMapping(value="/addoperatorlink")
	public String addOperatorLink(Model m) {
		log.info("���ô���������addOperatorLink");
		m.addAttribute("titleinfo","��������Ա");
		return "newOperator";
	}
	/**
	 * ���Ӳ���Ա������
	 * @param o
	 * @param result
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/addoperator",method=RequestMethod.POST)
	public String addOperator(@Valid Operators o,String[] operatorsex,String[] isadmin,BindingResult result,Model m) {
		log.info("���ô�������: addOperator()");
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
		m.addAttribute("titleinfo", "��������Ա");
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
			m.addAttribute("operatorinfo", "����Ա���ӳɹ�");
		} catch (Exception e) {
			log.warn("����Ա����ʧ�ܣ�"+e);
			m.addAttribute("operatorinfo", "����Ա����ʧ��");
		}
		return "newOperator";
	}
	@RequestMapping(value="/showoperator")
	public String showOperator(Model m) {
		log.info("���ô�������: showOperator()");
		m.addAttribute("titleinfo", "���²���Ա");
		ArrayList<Operators> list=(ArrayList<Operators>) operatordao.getOperators(1,5);
		m.addAttribute("list", list);
		return "modifyOperator";
	}
	@RequestMapping(value="/modifyoperatorlink",method=RequestMethod.POST)
	public String modifyOperatorLink(Operators o,String[] operatorid,BindingResult result,Model m) {
		log.info("���ô�������: modifyOperatorLink()");
		m.addAttribute("titleinfo", "�޸Ĳ���Ա");
		log.info(operatorid);
		Operators operators = operatordao.getOperatorsById(o.getOperatorid());
		m.addAttribute("operators", operators);
		return "modOperator";
	}
	@RequestMapping(value="/modifyoperator",method=RequestMethod.POST)
	public String modifyOperator(@Valid Operators o,String[] operatorsex,String[] isadmin,BindingResult result,Model m) {
		log.info("���ô�������: modifyoperator()");
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
		m.addAttribute("titleinfo", "�޸Ĳ���Ա");
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
			m.addAttribute("operatorinfo", "����Ա�޸ĳɹ�");
		} catch (Exception e) {
			log.warn("����Ա����ʧ�ܣ�"+e);
			m.addAttribute("operatorinfo", "����Ա�޸�ʧ��");
		}
//		 return "redirect:/hello";
//		 return "forward:/hello"; 
		   return "redirect:/showoperator"; 
	}
	@RequestMapping(value="/deleteOperator",method=RequestMethod.POST)
	public String deleteOperator(String[] operatorselectid,Model m) {
		log.info("���ô�������: deleteOperator()");
		m.addAttribute("titleinfo", "ɾ������Ա");
		int operatorid=Integer.parseInt(operatorselectid[0]);
		try {
			operatordao.deleteOperator(operatorid);
			m.addAttribute("operatorinfo", "ɾ������Ա�ɹ�");
			System.out.println("operatorinfo");
		} catch (Exception e) {
			log.warn("ɾ������Աʧ�ܣ�"+e);
			m.addAttribute("operatorinfo", "ɾ������Աʧ��");
		}
		return "redirect:/deletetoshow";
	}
	@RequestMapping(value="/deleteOperators",method=RequestMethod.POST)
	public String deleteOperators(String[] operatorselectid,Model m) {
		log.info("���ô�������: deleteOperators()");
		m.addAttribute("titleinfo", "ɾ������Ա");
		ArrayList<Integer> operatorids = new ArrayList<>();
		for(String id:operatorselectid) {
			operatorids.add(Integer.parseInt(id));
		}
		try {
			operatordao.deleteOperators(operatorids);
			m.addAttribute("operatorinfo", "ɾ������Ա�ɹ�");
		} catch (Exception e) {
			log.warn("ɾ������Աʧ�ܣ�"+e);
			m.addAttribute("operatorinfo", "ɾ������Աʧ��");
		}
		return "redirect:/deletetoshow";
	}
	@RequestMapping(value="/deletetoshow")
	public String deletetoshow(Model m,@RequestParam(value="operatorinfo",required=true)String operatorinfo) {
		log.info("���ô�������: showOperator()");
		m.addAttribute("titleinfo", "���²���Ա");
		ArrayList<Operators> list=(ArrayList<Operators>) operatordao.getOperators(1,5);
		m.addAttribute("operatorinfo",operatorinfo);
		m.addAttribute("list", list);
		return "modifyOperator";
	}
}
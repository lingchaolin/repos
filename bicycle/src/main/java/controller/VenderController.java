package controller;

import com.github.pagehelper.PageInfo;
import model.Vender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.IVenderService;

import java.util.Map;

@Controller
public class VenderController {

    @Autowired
    private IVenderService venderService;

    @RequestMapping("/vender")
    public String venderMain(){
        return "/WEB-INF/vender/bicyclesta.jsp";
    }

    @RequestMapping("/addvender")
    public String addVender(Vender vender){
        venderService.addVender(vender);
        return "redirect:/spring/vender";
    }

    @RequestMapping("/showvender")
    public String showVender(@RequestParam Map<String, Object> params, Model model){
        PageInfo page = venderService.showVender(params);
        model.addAttribute("page", page);
        return "/WEB-INF/vender/vendertable.jsp";
        }
    }


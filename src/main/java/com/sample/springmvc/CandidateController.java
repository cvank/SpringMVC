package com.sample.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.CandidateDaoImpl;
import com.springmvc.model.Candidate;

@Controller
public class CandidateController {
	
	@Autowired
	CandidateDaoImpl candidatedao;

	
	@RequestMapping("/candidateform")    
    public String showform(Model m){    
        m.addAttribute("command", new Candidate());  
        return "candidateform";   
    } 
	
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("candidate") Candidate candidate){    
		candidatedao.save(candidate);    
        return "redirect:/viewCandidates";  
    }  
	

	@GetMapping("/viewCandidates")    
    public String viewCandidateInfo(Model m){    
        List<Candidate> list=candidatedao.getCandidates();    
        m.addAttribute("list",list);
        return "viewCandidates";    
    }
/*	
	@GetMapping("/viewCandidatesInfo")    
    public String viewCandidatesInfo(@RequestParam("id") int empId, Model m){    
        List<Candidate> list=candidatedao.getCandidates();    
        m.addAttribute("list",list);
        System.out.println("candidate id :"+empId);
        return "viewCandidates";    
    }*/
	
	@RequestMapping(value="/viewCandidates/{id}")    
    public String getCandidateDetails(@PathVariable("id") int id, @RequestParam("empid") int empId, Model m){    
        List<Candidate> list=candidatedao.getCandidates();    
        m.addAttribute("list",list);
        System.out.println("candidate id :"+empId);
        System.out.println("Sample response for Id "+id);
        return "viewCandidates";   
    }
}

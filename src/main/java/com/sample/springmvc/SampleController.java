package com.sample.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	@RequestMapping("/sample_page")  
    public String redirect()  
    {  
        return "page2";  
    }     
@RequestMapping("/sample_page2")  
public String display()  
{  
    return "final_page";  
}  
}  
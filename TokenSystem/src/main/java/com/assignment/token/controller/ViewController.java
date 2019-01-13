package com.assignment.token.controller;


import com.assignment.token.businessObject.Token;
import com.assignment.token.entity.Customer;
import com.assignment.token.service.CustomerService;
import com.assignment.token.util.TokenUtils;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

@Controller
public class ViewController {


    @Autowired
    CustomerService service;

    static final Logger logger= Logger.getLogger(ViewController.class.getName());
    
    
    @GetMapping("/token")
    public ModelAndView createToken(){

       return new ModelAndView("showtoken");
    }

    @PostMapping("/token")
    public ModelAndView showToken(String mobileNumber){

        ModelAndView mv = new ModelAndView();

        Token token = new Token();

        token.setTokenId("TK"+ TokenUtils.counter++);
      
        token.setCreatedOn(LocalTime.now().toString());
       
        Customer cst = service.findCustomerByMobileNumber(mobileNumber);
        
        if(null != mobileNumber && null !=  cst)
        {
        	if(cst.getIsPrivileged())
        	{
        		token.setForPrivilegedCustomer(1);
        		TokenUtils.serviceCounterQueue.add(token);
        	}
        	else
        	{
        		token.setForPrivilegedCustomer(0);
        		TokenUtils.serviceCounterQueue.add(token);
        	}
        }
        else{
        	token.setForPrivilegedCustomer(0);
        	TokenUtils.serviceCounterQueue.add(token);
        }

        //logger.info("Queue "+ TokenUtils.serviceCounterQueue + "\n Peeking Queue" + TokenUtils.serviceCounterQueue.element());      
        mv.addObject("token",token);
        mv.setViewName("showtoken");

        return mv;
    }

    @GetMapping("/display")
    public ModelAndView displayToken(){

    	ModelAndView mv = new ModelAndView();
    	
    	
    	for(Map.Entry<String, Token> entry : TokenUtils.counters.entrySet())
    	{
			if(entry == null)
				break;
			
			
    		if(null == entry.getValue() && !TokenUtils.serviceCounterQueue.isEmpty())
    		{
    			Token t = TokenUtils.serviceCounterQueue.element();
    			t.setCounter(entry.getKey());
    			entry.setValue(t);
    			TokenUtils.serviceCounterQueue.remove();
    		}
    	}
    	
    	logger.info("Counter Queue "+ TokenUtils.counters);
    	
    	
    	
    	mv.addObject("counter",new ArrayList<Token>(TokenUtils.counters.values()));
    	
    	mv.addObject("queue",TokenUtils.serviceCounterQueue);
    	mv.setViewName("display");
    	    	
       return mv;
    }
    
    
    @GetMapping("/counter")
    public ModelAndView getCounter(){

       return new ModelAndView("counter");
    }
    
    
    @PostMapping("/counter")
    public ModelAndView postCounter(String counterNumber){

       ModelAndView mv = new ModelAndView();
       
       Token tk = TokenUtils.counters.get("Counter "+counterNumber);
       
       if(null != tk)
       {
    	   mv.addObject("token",tk);
    	   mv.addObject("counterNumber",counterNumber);
    	   //TokenUtils.counters.put("Counter "+counterNumber, null);
       }
       else
    	   mv.addObject("message", "No One Assigned Yet");
    	
       mv.setViewName("showcountertoken");
       
       return mv;
    }
    

    
    
    @GetMapping("/delete/{counterNumber}")
    public String deleteCounter(@PathVariable String counterNumber){

       //ModelAndView mv = new ModelAndView();
       TokenUtils.counters.put("Counter "+counterNumber, null);
       
       //mv.setViewName("counter");
       
       return "redirect:/counter";
    }
    
    
    
    
    
    

}

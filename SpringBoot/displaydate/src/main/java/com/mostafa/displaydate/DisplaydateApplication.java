package com.mostafa.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DisplaydateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplaydateApplication.class, args);
	}
	
	  @RequestMapping("/")
	  public String index() {
	      return "index.jsp";
	    }
	  
	  @RequestMapping("/date")
	  public String date(Model model) {
		  Date date = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d zzz yyyy");
		  String formatDate = formatter.format(date);
		  model.addAttribute("date", formatDate);
	      return "date.jsp";
	    }
	  
	  @RequestMapping("/time")
	  public String time(Model model) {
		  Date time = new Date();
		  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm" );
		  String formatTime = formatter.format(time);
		  model.addAttribute("time", formatTime);
	      return "time.jsp";
	    }
		
	}



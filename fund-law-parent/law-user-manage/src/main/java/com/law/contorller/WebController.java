package com.law.contorller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.law.entity.User;
import com.law.service.UserService;


@RestController
@RefreshScope
public class WebController {
	
	@Value("${foo}")
	String foo;
	
	@Autowired
	UserService userService;

	@GetMapping(value = "/foo")
	public String hi(){
		return "hi " + foo;
	}
	
	@GetMapping(value="/getSessionId")
	public String getSessionId(HttpServletRequest request){
		
		Object o = request.getSession().getAttribute("springboot");
		if(o == null){
			o = "spring boot 牛逼了!!!有端口"+request.getLocalPort()+"生成";
			request.getSession().setAttribute("springboot", o);
		}
		
		return "端口=" + request.getLocalPort() +  " sessionId=" + request.getSession().getId() +"<br/>"+o;
	}

}

package shiv.com.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import shiv.com.impl.MessageServiceImpl;

@RestController
public class MessageRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageRestController.class);
	
	@Autowired
	private MessageServiceImpl service;
	
	@GetMapping("/")
	public String loadDefault() {
		//String msg = "Call your resource";
		String msg = service.loadText();
		return msg;
	}
	
	
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		logger.debug("welcome method execution started...");
		logger.info("welcome method execution started...");
		String msg = "Welcome to spring-boot & micro-services";
		logger.info("welcome method execution terminated");
		return msg;
	}
	
	@GetMapping("/greet")
	public String greetMsg() {
		logger.info("greet method execution started...");
		String msg = "Good Morning...!!";
		logger.info("greet method execution terminated");
		return msg;
	}

}

package shiv.com.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	public String loadText() {
		logger.warn("service method loaded....");
		return "Service method executed...";
	}

}

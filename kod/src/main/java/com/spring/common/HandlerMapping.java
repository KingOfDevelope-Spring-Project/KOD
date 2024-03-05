package com.spring.common;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String,Controller> mappings;
	
	public HandlerMapping() {
		mappings=new HashMap<String,Controller>();
		
		// mappings.put("/main.do", new LoginController());
	}
	
	public Controller getController(String commend) {
		return mappings.get(commend);
	}
}

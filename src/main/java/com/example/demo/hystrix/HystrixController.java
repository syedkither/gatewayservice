package com.example.demo.hystrix;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@CrossOrigin
@RestController
@RequestMapping("/fallback")
public class HystrixController {

	@GetMapping("/student")	
	public Map<String, Object> studentServiceFallback() {

		ObjectNode courseNode = new ObjectMapper().createObjectNode();
		courseNode.put("title", "ML");
		courseNode.put("description", "Machine Learning Advanced");
		courseNode.put("active", "true");
		courseNode.put("fee", "1400.00");
		courseNode.put("courseId", "1");
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("id", "1");
		map.put("name", "John Doe");
		map.put("age", "15");
		map.put("course", courseNode);

		return map;
	}

	@GetMapping("/course")
	public ObjectNode courseServiceFallback() {
		ObjectNode objectNode = new ObjectMapper().createObjectNode();
		objectNode.put("title", "ML");
		objectNode.put("description", "Machine Learning Advanced");
		objectNode.put("active", "true");
		objectNode.put("fee", "1400.00");
		objectNode.put("courseId", "1");
		return objectNode;

	}
}

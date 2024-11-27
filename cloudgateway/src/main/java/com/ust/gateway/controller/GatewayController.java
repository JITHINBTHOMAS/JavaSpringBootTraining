package com.ust.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/gateway")
public class GatewayController {
//	@Autowired
//	RestTemplate template;
//	
//	@GetMapping(value="/getFact/{num}")
//	public String fact(@PathVariable int num){
//		String url = "http://localhost:8074/rest/factorial/"+num;
//		String list = template.getForObject(url, String.class);
//		return list;
//	}
}

package com.ssafy.FFP.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Service.MissMatchService;

@CrossOrigin(origins = { "http://localhost:5500",
		"https://j6e105.p.ssafy.io" }, allowCredentials = "true", allowedHeaders = "*", methods = { RequestMethod.GET,
				RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
				RequestMethod.OPTIONS })

@RestController
public class MissMatchController {

	@Autowired
	MissMatchService missMatchService;

	@PostMapping("/kmeans")
	public List<DatasetDto> matching(@RequestBody Map<String, String> map) {
		return missMatchService.matching(map);
	}
	
	@GetMapping("/kmeans")
	public String test() {
		String path = System.getProperty("user.dir"); 
		System.out.println("현재 작업 경로: " + path);
		return path;
	}
}

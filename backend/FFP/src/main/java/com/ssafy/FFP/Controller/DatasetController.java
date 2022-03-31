package com.ssafy.FFP.Controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ssafy.FFP.Service.DatasetService;

@CrossOrigin(origins = {"http://localhost:5500", "https://j6e105.p.ssafy.io"}, allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD,
        RequestMethod.OPTIONS })

@RestController
public class DatasetController {
	
	@Autowired
	DatasetService Service;

	@PostMapping("/dataset")
	public int DatasetInsert() { // 일단 2021년도까지 데이터는 모두 가져와서 데이터베이스에 저장 
		return Service.DataInsert();
	}
	
	@GetMapping("/dataset")
	public Map<String, Integer> Datasetselect() { // 메인에 필요한 데이터 넘겨줌
		return Service.DataSelect();
	}
	
	public void Datasetadd() { // 실시간 데이터 추가
		Service.DataAdd();
	}
	
	@PutMapping("/dataset")
	public int DatasetUpdate() { // 최근 4달 데이터 가져와서 새로 갱신하는 방식
		return Service.DataUpdate();
	}
}

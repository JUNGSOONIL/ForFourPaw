package com.ssafy.FFP.Service;

import java.util.List;
import java.util.Map;

import com.ssafy.FFP.Dto.DatasetDto;

public interface MissMatchService {
	public List<DatasetDto> matching(Map<String, String> map);
}

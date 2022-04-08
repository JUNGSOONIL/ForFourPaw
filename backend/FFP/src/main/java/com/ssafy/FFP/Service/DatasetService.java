package com.ssafy.FFP.Service;

import java.util.Map;

public interface DatasetService {
	public int DataInsert();
	public int DataUpdate();
	public Map<String, Integer> DataSelect();
	public void DataAdd();
}

package com.ssafy.FFP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.FFP.Dao.ShelnimalDao;
import com.ssafy.FFP.Dto.DatasetDto;
import com.ssafy.FFP.Dto.SearchDto;
import com.ssafy.FFP.Dto.ShelnimalDto;

@Service
public class ShelnimalServiceImpl implements ShelnimalService {

    @Autowired
    ShelnimalDao shelnimalDao;

    @Override
    public ShelnimalDto select(int no) {
        ShelnimalDto shelnimalDto = shelnimalDao.select(no);
        return shelnimalDto;
    }

    @Override
    public List<ShelnimalDto> list(int sdt, int offset) {
        List<ShelnimalDto> shelnimalDtos = shelnimalDao.list(sdt, offset);
        return shelnimalDtos;

    }

    @Override
    public List<ShelnimalDto> match(int userNo) {
        List<ShelnimalDto> shelnimalDtos = shelnimalDao.match(userNo);
        return shelnimalDtos;
    }

    @Override
    public List<ShelnimalDto> find(SearchDto searchDto) {
        return shelnimalDao.find(searchDto);
    }

	@Override
	public List<DatasetDto> mainList() {
		String processState = "보호중";
		List<DatasetDto> shelnimalDtos = shelnimalDao.mainList(processState);
		return shelnimalDtos;
	}

	@Override
	public List<String> searchList(String kind) {
		System.out.println(kind);
		List<String> kinds = shelnimalDao.searchList(kind);
		System.out.println(kinds);
		return kinds;
	}
}

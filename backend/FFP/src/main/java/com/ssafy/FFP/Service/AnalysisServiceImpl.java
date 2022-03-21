package com.ssafy.FFP.Service;


import com.ssafy.FFP.Dto.AnalysisResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysisServiceImpl implements  AnalysisService {


    private static final int SUCCESS = 1;
    private static final int FAIL = -1;

    @Override
    public AnalysisResultDto test() {

        AnalysisResultDto result = new AnalysisResultDto();
        result.setNumber(486);

        // 여기서 실행

        return result;
    }

}

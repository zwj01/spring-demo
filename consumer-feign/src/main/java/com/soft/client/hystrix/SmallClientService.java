package com.soft.client.hystrix;

import com.soft.bean.SmallDto;
import com.soft.client.SmallClient;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ZWJ
 * @date 2019/8/21 16:18
 * @Version 1.0
 **/
@Component
public class SmallClientService implements SmallClient {
    @Override
    public SmallDto homeScreen() {
        return null;
    }

    @Override
    public SmallDto chartInformation(String solutionid) {
        return null;
    }

    @Override
    public SmallDto chartData(Map map) {
        return null;
    }

    @Override
    public SmallDto tableData(Map map) {
        return null;
    }
}

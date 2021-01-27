package com.example.backend.web;

import com.alibaba.fastjson.JSONObject;
import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.kuaidi100Utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

    private static Logger longger = LoggerFactory.getLogger("logistics");

    private String key = PropertiesReader.get("key");
    private String customer = PropertiesReader.get("customer");

    @PostMapping("")
    public Result query(@RequestBody QueryTrackParam queryTrackParam) {

        String param = JSONObject.toJSONString(queryTrackParam);
        longger.info("---------------->RequestParam:"+param);
        String sign = SignUtils.querySign(param ,key,customer);
        String jsonString = GetPostUntil.sendPost(ApiInfoConstant.QUERY_URL, "customer="+customer+"&sign="+sign+"&param="+param);
        longger.info("---------------->ReturnJson:"+jsonString);
        return ResultGenerator.genSuccessResult(jsonString);
    }

}

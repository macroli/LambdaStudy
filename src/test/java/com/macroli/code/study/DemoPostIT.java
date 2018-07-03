package com.macroli.code.study;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.macroli.code.study.Rqrs.Request;
import com.macroli.code.study.Rqrs.Response;
import com.macroli.code.study.baselib.BaseIntegrationTest;
import com.macroli.code.study.casemodel.Case;
import com.macroli.code.study.casemodel.TestCases;
import com.macroli.code.study.util.JsonDataReadUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class DemoPostIT extends BaseIntegrationTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(DemoPostIT.class);

    @Test
    public void postTestDemo() {
        Map<String, String> headers = new HashMap();
        headers.put("Client-Id", "Test_Demo");
        headers.put("Accept", ContentType.JSON.toString());

        String casePath = "testcases/update";
        String testcasesFileName = "testcases";
        TestCases testCases = JsonDataReadUtil.readJsonFile(casePath, testcasesFileName, TestCases.class);
        if (testCases == null) {
            LOGGER.info("Fail to get the test cases in postTestDemo method");
            return;
        }
        for (Case aCase : testCases.getCase_path()) {
            String caseName = aCase.getCase_name();
            String mockData = aCase.getDownstream_mock_data();
            String expectFileName = aCase.getExpect();
            String fileSeparator = "/";
            String expectFilePath = fileSeparator + caseName + fileSeparator + expectFileName;
            Response expectResponse = JsonDataReadUtil.readJsonFile(casePath, expectFilePath, Response.class);
            String requestFilePath = caseName + fileSeparator + "request";
            Request request = JsonDataReadUtil.readJsonFile(casePath, requestFilePath, Request.class);
            com.jayway.restassured.response.Response response = RestAssured.given().contentType("application/json")
                    .headers(headers)
                    .when()
                    .body(request)
                    .post("/demo/post");

            Response actualResponse = response.getBody().as(Response.class);

            response.then().statusCode(200).contentType(ContentType.JSON);

            boolean isOk = resultCompare(expectResponse, actualResponse, caseName);
            if (!isOk) {
                StringBuilder msg = new StringBuilder(50);
                msg.append(caseName)
                        .append("test failure");
                LOGGER.info(msg.toString());
            }
        }

    }

    public boolean resultCompare(Response expectResult, Response actualResult, String caseName) {
        if (actualResult == null) {
            StringBuilder msg = new StringBuilder(50);
            msg.append(caseName)
                    .append("test failure, because of actual result is null");
            LOGGER.info(msg.toString());
            return false;
        }
        if(expectResult.getHotelName().equals(actualResult.getHotelName())
                && expectResult.getPrice().equals(actualResult.getPrice())) {
            LOGGER.info(caseName+" runs success");
            return true;
        }
        return  false;
    }
}

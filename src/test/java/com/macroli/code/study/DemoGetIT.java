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


public class DemoGetIT extends BaseIntegrationTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(DemoGetIT.class);

    @Test
    public void getTestDemo() {
        Map<String, String> headers = new HashMap();
        headers.put("Client-Id", "Test_Demo");
        headers.put("Accept", ContentType.JSON.toString());

        String casePath = "testcases/get";
        String testcasesFileName = "testcases";
        TestCases testCases = JsonDataReadUtil.readJsonFile(casePath, testcasesFileName, TestCases.class);
        if (testCases == null) {
            LOGGER.info("Fail to get the test cases in getTestDemo method");
            return;
        }
        for (Case aCase : testCases.getCase_path()) {
            String caseName = aCase.getCase_name();
            String mockData = aCase.getDownstream_mock_data();
            String expectFileName = aCase.getExpect();
            String expectFilePath = File.pathSeparator+caseName+File.pathSeparator+expectFileName;
            Response expectResponse = JsonDataReadUtil.readJsonFile(casePath,expectFilePath,Response.class);

            com.jayway.restassured.response.Response response = RestAssured.given().contentType("application/json")
                    .headers(headers)
                    .when()
                    .get("/demo/get");

            Response actualResponse = response.getBody().as(Response.class);

            response.then().statusCode(200).contentType(ContentType.JSON);

            boolean isOk = resultCompare(expectResponse, actualResponse, caseName);
            if(!isOk){
                LOGGER.info("");
            }
        }

    }

    @Override
    public boolean resultCompare(Response expectResult, Response actualResult, String caseName) {
        if (actualResult == null) {

        }
        return false;
    }
}

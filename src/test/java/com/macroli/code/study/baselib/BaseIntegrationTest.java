package com.macroli.code.study.baselib;


import com.jayway.restassured.RestAssured;
import com.macroli.code.study.Rqrs.Response;
import com.macroli.code.study.Starter;
import com.macroli.code.study.init.AutoTestConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Starter.class, AutoTestConfig.class}, webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = { "classpath:../test-classes/application.properties"})
//@ActiveProfiles("int")
public abstract class BaseIntegrationTest
{
    protected static final String BASE_URI = "http://localhost";

    @LocalServerPort
    private int port;

 /*   @Value("${jksPassword}")
    private String jksPassword;*/

    @Before
    public void setup()
    {

        RestAssured.baseURI = BASE_URI;
        RestAssured.port = port;
        /*RestAssured.useRelaxedHTTPSValidation();
        RestAssured.config().getSSLConfig().with()
                .keystore("classpath:../test-classes/keystore.jks", jksPassword);*/

    }
    public abstract boolean resultCompare(Response expectResult, Response actualResult, String caseName);
}

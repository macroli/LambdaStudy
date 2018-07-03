package com.macroli.code.study.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class JsonDataReadUtil
{

    private final static Logger LOGGER = LoggerFactory.getLogger(JsonDataReadUtil.class);
    public static <T> T readJsonFile(String fileName, Class<?> tClass)
    {
        return readJsonFile(null, fileName, tClass);
    }

    public static <T> T readJsonFile(String casePath, String fileName, Class<?> tClass)
    {

        String fileSeparator = "/";
        String fileCasePath = fileSeparator;
        if (StringUtils.isNotEmpty(casePath))
        {
            fileCasePath = fileSeparator + casePath + fileSeparator;
        }

        ObjectMapper mapper = new ObjectMapper();
        InputStream is = JsonDataReadUtil.class.getResourceAsStream(fileCasePath + fileName + ".json");
        try
        {
            return (T) mapper.readValue(is, tClass);
        }
        catch (IOException e)
        {
            LOGGER.info("read test cases list file failure!");
            return null;
        }
    }
}

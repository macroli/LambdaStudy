package com.macroli.code.study.Controller;

import com.macroli.code.study.Rqrs.Request;
import com.macroli.code.study.Rqrs.Response;
import com.macroli.code.study.service.DownStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class TestFramework {

    @Autowired
    private DownStreamService downStreamService;

    @GetMapping(value = "/demo/get",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> get(
            @RequestHeader("Client-Id") String clientId) {

        Response response = new Response();
        response.setHotelName("Hildon");
        response.setHotelType("ARI");
        response.setRoomType("Stand Room");
        response.setPrice(new BigDecimal(518));

        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/demo/post",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> post(
            @RequestHeader("Client-Id") String clientId,
            @RequestBody Request request) {

        Response response = new Response();

        switch (request.getHotelId()) {
            case 1:
                response.setHotelName("CaseA");
                response.setHotelType("ARI");
                response.setRoomType("Stand Room");
                Integer price = downStreamService.callDownStream(518);
                response.setPrice(new BigDecimal(price));
                break;
            case 2:
                response.setHotelName("CaseB");
                response.setHotelType("ARI");
                response.setRoomType("Stand Room");
                Integer price1 = downStreamService.callDownStream(5188);
                response.setPrice(new BigDecimal(price1));
                break;
            default:
                response.setHotelName("Default");
                response.setHotelType("ARI");
                response.setRoomType("Stand Room");
                Integer price2 = downStreamService.callDownStream(888);
                response.setPrice(new BigDecimal(price2));

                break;

        }

        return ResponseEntity.ok().

    body(response);
}
}

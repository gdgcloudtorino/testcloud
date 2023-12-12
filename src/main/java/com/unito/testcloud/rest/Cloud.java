package com.unito.testcloud.rest;

import com.unito.testcloud.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/cloud")
public class Cloud {

    @Value("${app.foo}")
    String foo;

    @Value("${app.bar}")
    String bar;

    @GetMapping(path = "/test")
    public ResponseDTO getTest() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(200);
        responseDTO.setDescription("Test "+foo);
        return responseDTO;
    }

    @GetMapping(path = "/test2")
    public ResponseDTO getTest2() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setCode(200);
        responseDTO.setDescription("Test "+bar);
        return responseDTO;
    }
}

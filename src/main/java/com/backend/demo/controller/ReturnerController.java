package com.backend.demo.controller;

import com.backend.demo.model.Genders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ReturnerController {
    /********************************************************************************************/
    @PostMapping("/headersReturner")
    public Map<String, String> headersReturnerPost(@RequestHeader Map<String, String> headers) {
        return headers;
    }
    /********************************************************************************************/
    @PostMapping("/bodyJsonReturner")
    public Map<String, Object> bodyJsonReturner(@RequestBody Map<String, Object> requestBody) {
        return requestBody;
    }
    /********************************************************************************************/
    @RequestMapping(
        value = "/bodyWwwFormReturner",
        method = RequestMethod.POST,
        //consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
        consumes = "application/x-www-form-urlencoded",
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Object bodyWwwFormReturner(HttpServletRequest request) throws JsonProcessingException {
        Map<String, String[]> requestBody = request.getParameterMap();
        ObjectMapper mapper = new ObjectMapper();
        Object jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestBody);
        return jsonResult;
    }
    /********************************************************************************************/
    @GetMapping("/headersReturner")
    public Map<String, String> headersReturnerGet(@RequestHeader Map<String, String> headers) {
        return headers;
    }
    /********************************************************************************************/
}

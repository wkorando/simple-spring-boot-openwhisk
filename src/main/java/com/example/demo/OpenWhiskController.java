package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OpenWhiskController {
	
    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public ResponseEntity<Map> init(@RequestBody Map params) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("OK", true);

        return new ResponseEntity(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/run", method = RequestMethod.POST)
    public ResponseEntity< Map > run(@RequestBody Map params) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", params.get("name"));
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }
}

package com.example.demo;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
public class OpenWhiskController {
	
    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public ResponseEntity<?> init(@RequestBody JsonObject args) {
    	System.out.println("In init");
    	System.out.println(args.toString());

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/run", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Object, Object> run(@RequestBody Map<Object, Object> args) {
    	System.out.println("In run");
    	System.out.println(args.toString());
    	Map<Object, Object> response = new   HashMap<>();
        String result = "Hello! Welcome to OpenWhisk...";
        response.put("message", result);
        return response;
    }
}

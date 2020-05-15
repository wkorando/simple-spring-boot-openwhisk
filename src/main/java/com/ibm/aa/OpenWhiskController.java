package com.ibm.aa;

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

	/**
	 * OpenWhisk calls /init on cold start for a function. If any initialization
	 * steps are needed to get a function into a ready state, run here. OpenWhisk
	 * only checks for a 200 response.
	 * 
	 * @param args
	 * @return
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public ResponseEntity<?> init(@RequestBody JsonObject args) {
		System.out.println("In init");
		System.out.println(args.toString());
		return ResponseEntity.ok().build();
	}

	/**
	 * Openwhisk calls /run when executing the function. It passes in a JSON object
	 * that's specified <a href=
	 * "https://github.com/apache/openwhisk/blob/master/docs/actions-new.md#activation">here</a>
	 * 
	 * @param args
	 * @return
	 */
	@PostMapping(value = "/run", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<Object, Object>> run(@RequestBody Map<Object, Object> args) {
		System.out.println("In run");
		System.out.println(args.toString());
		Map<Object, Object> response = new HashMap<>();

		response.put("message", "TEST");
		return ResponseEntity.ok().body(response);
	}
}

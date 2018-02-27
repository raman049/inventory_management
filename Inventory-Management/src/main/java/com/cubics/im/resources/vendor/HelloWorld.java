package com.cubics.im.resources.vendor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Service;

@Path("/hello")
@Service
public class HelloWorld {

	@GET
	public String HelloWord() {
		return "hello";
	}
}

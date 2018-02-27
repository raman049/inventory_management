package com.cubics.im;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.cubics.im.exception.provider.GenericExceptionMap;
import com.cubics.im.resources.product.ProductResource;
import com.cubics.im.resources.vendor.HelloWorld;
import com.cubics.im.resources.vendor.VendorResource;

@Configuration
public class RestConfig extends ResourceConfig {
	
	public RestConfig() {
		this.register(HelloWorld.class);
		this.register(VendorResource.class);
		this.register(ProductResource.class);
		this.packages("com.cubics.im.exception");
		//this.register(GenericExceptionMap.class);
	}
}

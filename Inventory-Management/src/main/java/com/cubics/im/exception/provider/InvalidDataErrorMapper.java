package com.cubics.im.exception.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.cubics.im.entity.vendor.ErrorInfoVendor;
import com.cubics.im.exception.InvalidDataError;

@Provider
@Component
public class InvalidDataErrorMapper implements ExceptionMapper<InvalidDataError> {

	public InvalidDataErrorMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Response toResponse(InvalidDataError arg0) {
		ErrorInfoVendor errorInfo = new ErrorInfoVendor();
		errorInfo.setErrCode("Error 208 ");
		errorInfo.setErrDesc("Invalid data. Please check name and code and email format.");
		return Response.status(208).entity(errorInfo).build();
	}

}

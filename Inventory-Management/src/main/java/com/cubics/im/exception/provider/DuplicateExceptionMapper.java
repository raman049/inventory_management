package com.cubics.im.exception.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.cubics.im.entity.vendor.ErrorInfoVendor;
import com.cubics.im.exception.DuplicateDataError;

@Provider
@Component
public class DuplicateExceptionMapper implements ExceptionMapper<DuplicateDataError> {

	public DuplicateExceptionMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Response toResponse(DuplicateDataError arg0) {
		ErrorInfoVendor errorInfo = new ErrorInfoVendor();
		errorInfo.setErrCode("Error 206 ");
		errorInfo.setErrDesc("Data entered is duplicate");
		return Response.status(206).entity(errorInfo).build();
	}

}

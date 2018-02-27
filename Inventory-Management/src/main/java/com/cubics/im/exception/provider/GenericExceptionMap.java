package com.cubics.im.exception.provider;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.cubics.im.entity.vendor.ErrorInfoVendor;
import com.cubics.im.exception.DataNotFound;

@Provider
@Component
public class GenericExceptionMap implements ExceptionMapper<DataNotFound> {

	@Override
	public Response toResponse(DataNotFound arg0) {
		ErrorInfoVendor errorInfo = new ErrorInfoVendor();
		errorInfo.setErrCode("Error 209 ");
		errorInfo.setErrDesc("Data does not exist in database");
		return Response.status(209).entity(errorInfo).build();//  .build();//.entity(errorInfo).build()
	}
}

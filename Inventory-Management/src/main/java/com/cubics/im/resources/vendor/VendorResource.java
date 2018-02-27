package com.cubics.im.resources.vendor;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubics.im.service.vendor.VendorService;
import com.cubics.im.service.vendor.VendorVO;

@Service
@Path("/vendor")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class VendorResource {

	@Autowired
	private VendorService vs;
	
	@POST
	public Response createVendor(final VendorVO vo) {
		VendorVO result = vs.createVendor(vo);
		return Response.ok().entity(result).build();
		
	}

	@PUT
	@Path("/update")
	public Response updateVendor(final VendorVO vo) {
		vs.updateVendor(vo);
		return Response.ok().entity(vo).build();
	}

	@PUT
	@Path("/activate/{id}")
	public Response activateVendor(@PathParam("id") final Long id) {
		vs.activateVendor(id);
		return Response.ok().build();
	}

	@PUT
	@Path("/deactivate/{id}")
	public Response deactivateVendor(@PathParam("id") final Long id) {
		vs.deactivateVendor(id);
		return Response.ok().build();
	}

	@GET
	@Path("/id/{id}")
	public Response findByID(@PathParam("id") final Long id) {
		VendorVO result = vs.findById(id);
		return Response.ok().entity(result).build();
	}

	@GET
	@Path("/code/{code}")
	public Response findByCode(@PathParam("code") final String code) {
		VendorVO result = vs.findByCode(code);
		return Response.ok().entity(result).build();
	}

	@GET
	@Path("/active")
	public Response searchVendor() {
		List<VendorVO> volsit = vs.searchActiveVendor();
		return Response.ok().entity(volsit).build();
	}


}

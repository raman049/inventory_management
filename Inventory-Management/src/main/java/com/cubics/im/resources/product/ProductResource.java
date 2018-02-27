package com.cubics.im.resources.product;

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

import com.cubics.im.service.product.ProductService;
import com.cubics.im.service.product.ProductVO;

@Service
@Path("/product")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class ProductResource {

	@Autowired
	private ProductService ps;

	@POST
	public Response createProduct(final ProductVO vo) {
		ProductVO result = ps.createProduct(vo);
		return Response.ok().entity(result).build();
	}

	@PUT
	@Path("/update")
	public Response updateProduct(final ProductVO vo) {
		ps.updateProduct(vo);
		return Response.ok().entity(vo).build();
	}

	@PUT
	@Path("/activate/{id}")
	public Response activateVendor(@PathParam("id") final Long id) {
		ps.activateProduct(id);
		return Response.ok().build();
	}

	@PUT
	@Path("/deactivate/{id}")
	public Response deactivateVendor(@PathParam("id") final Long id) {
		ps.deactivateProduct(id);
		return Response.ok().build();
	}

	@GET
	@Path("/code/{code}")
	public Response findByCode(@PathParam("code") final String code) {
		ProductVO result = ps.findByCode(code);
		return Response.ok().entity(result).build();
	}

	@GET
	 @Path("/active")
	 public Response searchVendor() {
	 List<ProductVO> volist = ps.searchActiveProduct();
	 return Response.ok().entity(volist).build();
	 }

	@PUT
	 @Path("/{code}/add/{quantity}")
	 public Response addQuantity( @PathParam("code")String code, @PathParam("quantity") final Long id) {
	 ps.addProduct(code, id);
	 return Response.ok().build();
	 }
	 
	

}

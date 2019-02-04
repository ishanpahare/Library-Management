package com.lms.libraryManagement.resources;

import com.lms.libraryManagement.dto.Vendor;
import com.lms.libraryManagement.services.VendorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/vendors")
public class VendorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getVendorList() {
        List<Vendor> vendorList =null;
        VendorService vendorService = new VendorService();
        vendorList=vendorService.getAllVendor();
        return vendorList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vendor getVendor(@PathParam("id") int id){
        VendorService vendorService = new VendorService();
        Vendor vendor = vendorService.getVendor(id);
        return vendor;
    }

    @POST
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vendor addVendor(@PathParam("name") String name){
        VendorService vendorService = new VendorService();
        Vendor vendor = vendorService.addVendor(name);
        return vendor;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteVendor(@PathParam("id") int id){
        VendorService vendorService = new VendorService();
        vendorService.deleteVendor(id);
    }

}

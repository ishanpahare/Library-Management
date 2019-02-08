package com.lms.libraryManagement.resources;

import com.lms.libraryManagement.dto.Vendor;
import com.lms.libraryManagement.services.VendorService;
import org.json.simple.JSONObject;

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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Vendor addVendor(JSONObject inputJsonObject){
        VendorService vendorService = new VendorService();
        String name = (String) inputJsonObject.get("name");
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

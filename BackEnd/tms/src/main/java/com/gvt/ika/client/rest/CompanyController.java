package com.gvt.ika.client.rest;


import com.gvt.ika.app.entity.bo.Company;
import com.gvt.ika.app.service.business.CompanyService;
import com.gvt.ika.common.rest.entity.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/company")
public class CompanyController {

@Autowired
private CompanyService companyService;

    @GetMapping(value = "/{companyId}")
    @ResponseBody
    public ResponseEntity<Response<Company>> getProductByProductId(@PathVariable("companyId") Long companyId) {
        Response<Company> companyResponse = new Response<Company>();
        Company resultset = companyService.findByCompanyId(companyId);
        if (resultset == null)
        {
            companyResponse.setStatus(HttpStatus.NOT_FOUND.value());
            companyResponse.setMessage("Company with companyId = "+companyId+" not Found.");
            return new ResponseEntity<Response<Company>>(companyResponse, HttpStatus.NOT_FOUND);
        }
        else
        {
            companyResponse.setPayload(resultset);
            companyResponse.setStatus(HttpStatus.OK.value());
            companyResponse.setMessage("Company with companyId = "+companyId+" Found.");
            return new ResponseEntity<Response<Company>>(companyResponse, HttpStatus.OK);
        }

    }
}

package testcase;

import com.gvt.ika.app.entity.bo.Company;
import com.gvt.ika.app.service.business.CompanyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyServiceTestCase extends  TestCase {
   @Autowired
   private CompanyService companyService;

    @Test
    public void saveOrUpdateCompany()
    {
        Company company = new Company();
        company.setName("gRandViewTech");
        companyService.saveOrUpdate(company);

    }
}

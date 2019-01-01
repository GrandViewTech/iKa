package com.gvt.ika.app;

import com.gvt.ika.app.service.business.CredentialService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CredentialServiceTestCase extends TestCase {


    private static String info ="";

    static {
        info+="Validation Criteria ";
        info +="^                       # start-of-string \n";
        info +="( ? =.*[0 - 9])         #a digit must occur at least once \n";
        info +="( ? =.*[a - z])         #a lower case letter must occur at least once \n";
        info +="( ? =.*[A - Z])         #an upper case letter must occur at least once \n";
        info +="( ? =.*[@#$ % ^&+=])    #a special character must occur at least once \n";
        info +="( ? =\\S + $)           #no whitespace allowed in the entire string \n";
        info +=" . {8,}                 #anything, at least eight places though \n";
        info +="$                       #end - of - string \n";

    }

        @Autowired
        CredentialService credentialService;

        @Test
        public void generateCredential() throws Exception
        {
            String username="sharmapuneet1510@gmail.com";
            String password="puneet1510@";
            Long userId=1L;
            credentialService.saveCredential(userId,username,password);
        }
}

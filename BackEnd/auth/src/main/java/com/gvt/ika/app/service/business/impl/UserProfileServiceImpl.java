package com.gvt.ika.app.service.business.impl;

import com.gvt.ika.app.service.business.UserProfileService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class UserProfileServiceImpl implements UserProfileService {

private static Logger  LOGGER = Logger.getLogger(UserProfileService.class);

@PostConstruct
public void init()
{
    LOGGER.info("UserProfileService Loaded Successfully");
System.out.print("dsdsdssd");
}
}

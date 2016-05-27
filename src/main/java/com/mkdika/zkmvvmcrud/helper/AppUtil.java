package com.mkdika.zkmvvmcrud.helper;

import com.mkdika.zkmvvmcrud.repository.ServiceRepository;
import com.mkdika.zkmvvmcrud.service.AppService;
import org.zkoss.zkplus.spring.SpringUtil;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
public class AppUtil {
    
    private static AppService appService;
       
    public static ServiceRepository svcRepo() {
        if (appService == null) {
            appService = (AppService) SpringUtil.getBean("appService");
        }
        return appService.getSvcRepo();
    }       
}

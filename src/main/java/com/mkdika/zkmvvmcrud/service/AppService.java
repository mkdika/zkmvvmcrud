package com.mkdika.zkmvvmcrud.service;

import com.mkdika.zkmvvmcrud.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@Service("appService")
@Transactional
public class AppService {
       
    @Autowired
    private ServiceRepository serviceRepository;
    
    public ServiceRepository getSvcRepo() {
        return this.serviceRepository;
    }            
}

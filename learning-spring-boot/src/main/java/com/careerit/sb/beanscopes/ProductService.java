package com.careerit.sb.beanscopes;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class ProductService  {

    public void showProducts() {
        System.out.println("ProductService: showProducts");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("ProductService: destroy");
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("ProductService: afterPropertiesSet");
    }

}

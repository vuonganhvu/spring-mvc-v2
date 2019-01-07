package com.itss.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("ping")
    public ResponseEntity ping() {
        Object controller = applicationContext.getBean("testController");
        System.out.println("bean testController " + controller);

        Object filter = applicationContext.getBean("testFilterServlet");
        System.out.println("bean testFilterServlet " + filter);
        return ResponseEntity.ok("connect success");
    }

    @GetMapping(value = "testParameters/{id}", params = {"param=anhvv", "param2!=d"})
    public ResponseEntity testParameters(@PathVariable String id){
        System.out.println("testParameters... id= " + id);
        return ResponseEntity.ok("OK");
    }

    @GetMapping(value = "testHeader", headers = "pH=anhvv")
    public ResponseEntity testHeader(){
        System.out.println("testHeader...");
        return ResponseEntity.ok("OK");
    }

}

package com.example.demo.tx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoTxController {

    private DemoTxService demoTxService;

    public DemoTxController(DemoTxService demoTxService) {
        this.demoTxService = demoTxService;
    }

    @GetMapping("/tx")
    public String callWithTx() {
        demoTxService.callRepository();
        return "OK";
    }
}

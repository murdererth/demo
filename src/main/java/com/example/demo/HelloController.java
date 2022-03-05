package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

//    GET /hello/{name}
//    {
//        "message" : "Hello John"
//    }

    @GetMapping("/hello/{name}")
    public HelloResponse sayHi(@PathVariable String name) {
        return new HelloResponse(helloService.concatData(name));
    }

//    GET /api/users — เรียกดูรายการ User ทั้งหมด
//    GET /api/users/{id} — เรียกดู User โดย user id
//    GET /api/users?name=xxxx — เรียกดูรายการ User ด้วยการค้นหาด้วย name
//    POST /api/users — สร้าง User ใหม่
//    PUT /api/users/{id} — แก้ไข User โดย user id
//    DELETE /api/users/{id} — ลบ User โดย user id

    @GetMapping("/hello")
    public HelloResponse sayHi2(@RequestParam(name = "id") String fooId, @RequestParam String name) {
        return new HelloResponse("Hello " + name + ", id " + fooId);
    }

}

package com.garken.springcloud.memberservice.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/member")
public class MemberInfoController {

    @GetMapping("/{id}")
    public String memberInfo(@PathVariable("id") String id) {
        return "return member info for member id: " + id;
    }

}

package com.example.demo.b5.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    @Secured("ROLE_ADMIN")
    @GetMapping("/system-statistics")
    public String getSystemStatistics() {
        return "[DỮ LIỆU TỐI CAO] Báo cáo: 1,200,000 CCU đồng thời. Doanh thu vật phẩm Arcade hôm nay: $45,000.";
    }
}
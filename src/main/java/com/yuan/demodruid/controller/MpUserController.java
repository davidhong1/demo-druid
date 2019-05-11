package com.yuan.demodruid.controller;


import com.yuan.demodruid.domain.entity.MpUser;
import com.yuan.demodruid.service.MpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuan
 * @since 2019-05-11
 */
@RestController
@RequestMapping("/mp-user")
public class MpUserController {

    @Autowired
    private MpUserService mpUserService;

    @GetMapping("/add")
    public Object post() {
        MpUser mpUser = new MpUser();
        mpUser.setUsername("yuan");
        mpUser.setAddress("广东深圳");
        mpUser.setOpenid("openid");
        mpUserService.save(mpUser);
        return "add";
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable Long id) {
        return mpUserService.getById(id);
    }

    @GetMapping("/del/{id}")
    public Object del(@PathVariable Long id) {
        mpUserService.removeById(id);
        return "del";
    }

}

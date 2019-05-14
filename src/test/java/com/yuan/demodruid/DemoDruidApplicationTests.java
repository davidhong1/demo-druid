package com.yuan.demodruid;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.demodruid.domain.entity.MpUser;
import com.yuan.demodruid.service.MpUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoDruidApplicationTests {

    @Autowired
    private MpUserService mpUserService;

    @Test
    public void test1() {

        // 插入新记录
        MpUser mpUser = new MpUser();
        mpUser.setId(1L);
        mpUser.setOpenid("openId");
        mpUser.setAddress("广东深圳");
        mpUser.setUsername("David Hong");
        mpUserService.save(mpUser);
        // 或者
        mpUser.insertOrUpdate();
        // 更新完成后，mpUser对象的id会被补全
        log.info("mpUser={}", mpUser.toString());

        // 通过主键id查询
        mpUser = mpUserService.getById(8);
        log.info("mpUser={}", mpUser.toString());
        // 条件查询，下面相当于xml中的 select * from mp_user where address = '"广东深圳' and username = 'David Hong' limit 1
        mpUser = mpUserService.getOne(new QueryWrapper<MpUser>().eq("address", "广东深圳").eq("username", "David Hong").last("limit 1"));
        // 批量查询
        List<MpUser> mpUserList = mpUserService.list();
        // 分页查询
        int pageNum = 1;
        int pageSize = 10;
        IPage<MpUser> mpUserIPage = mpUserService.page(new Page<>(pageNum, pageSize), new QueryWrapper<MpUser>().eq("openid", "openId"));
        // IPage to List
        List<MpUser> mpUserList1 = mpUserIPage.getRecords();
        // 总页数
        long allPageNum = mpUserIPage.getPages();

        // 修改更新
        mpUser.setAddress("广东广州");
        mpUserService.updateById(mpUser);
        // 或者
        mpUser.insertOrUpdate();

        // 通过主键id删除
        mpUserService.removeById(1);
        // 或者
        mpUser.deleteById();
    }

}

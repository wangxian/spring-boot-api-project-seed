package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User1;
import com.company.project.service.User1Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/07/02.
*/
@RestController
@RequestMapping("/user1")
public class User1Controller {
    @Resource
    private User1Service user1Service;

    @PostMapping("/add")
    public Result add(User1 user1) {
        user1Service.save(user1);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        user1Service.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(User1 user1) {
        user1Service.update(user1);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        User1 user1 = user1Service.findById(id);
        return ResultGenerator.genSuccessResult(user1);
    }

    /**
     * 列表
     *
     * 注意：排序只有 传了 分页才起作用
     * http://localhost:8080/user1/list?size=4&page=1
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "10") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size, "id desc");
        List<User1> list = user1Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}

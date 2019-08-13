// package com.company.project.web;
// import com.company.project.core.Result;
// import com.company.project.core.ResultGenerator;
// import com.company.project.model.User2;
// import com.company.project.service.User2Service;
// import com.github.pagehelper.PageHelper;
// import com.github.pagehelper.PageInfo;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
//
// import javax.annotation.Resource;
// import java.util.List;
//
// /**
// * Created by CodeGenerator on 2019/07/02.
// */
// @RestController
// @RequestMapping("/user2")
// public class User2Controller {
//     @Resource
//     private User2Service user2Service;
//
//     @PostMapping("/add")
//     public Result add(User2 user2) {
//         user2Service.save(user2);
//         return ResultGenerator.genSuccessResult();
//     }
//
//     @PostMapping("/delete")
//     public Result delete(@RequestParam Integer id) {
//         user2Service.deleteById(id);
//         return ResultGenerator.genSuccessResult();
//     }
//
//     @PostMapping("/update")
//     public Result update(User2 user2) {
//         user2Service.update(user2);
//         return ResultGenerator.genSuccessResult();
//     }
//
//     @GetMapping("/detail")
//     public Result detail(@RequestParam Integer id) {
//         User2 user2 = user2Service.findById(id);
//         return ResultGenerator.genSuccessResult(user2);
//     }
//
//     @GetMapping("/list")
//     public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//         PageHelper.startPage(page, size, "id desc");
//         List<User2> list = user2Service.findAll();
//         PageInfo pageInfo = new PageInfo(list);
//         return ResultGenerator.genSuccessResult(pageInfo);
//     }
// }

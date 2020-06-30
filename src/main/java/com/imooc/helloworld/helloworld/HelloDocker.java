package com.imooc.helloworld.helloworld;


import com.imooc.dao.UserDao;
import com.imooc.javabean.User;
import com.imooc.service.CopyFileServiceImpl;
import com.imooc.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
public class HelloDocker {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    CopyFileServiceImpl copyFileService;

    @Value("${centos.path}")
    private String filePath;

    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable("name")String name) {
        return "hello:"+name;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String inputPassword = request.getParameter("password");
        User user = userServiceImpl.getUser(userName);
        String password = user.getPassword();
        if(inputPassword.equals(password)){
            System.out.println("**********welcome"+userName+"**********");
        }else{
            return "register";
        }
        return "index";
    }

    @GetMapping("/uploadFile")
    public String getUploadFile(){
        return "success";
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        System.out.println("*********filePath*************"+filePath);
        File destFile = new File(filePath+fileName);
        try{
            file.transferTo(destFile);
            System.out.println("*********上传成功*************");
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "register";
    }

    @PostMapping("/copyFile")
    @ResponseBody
    public String copyFile(@RequestParam("targetPath")String targetPath){
        String code = copyFileService.CopyFile(targetPath);
        if("success".equals(code)){
            return "success";
        }
        return "register";
    }
}

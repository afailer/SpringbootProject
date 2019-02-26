package com.tjwq.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping(value = "/api/v1/gopage")
    public Object index(){
        return "index";
    }

    private static final String filePath = "/Users/admin/IdeaProjects/_1/src/main/resources/static/images/";

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request){
//        file.isEmpty();
//        file.getSize();
        String name = request.getParameter("name");
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return fileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "上传失败";
    }
}

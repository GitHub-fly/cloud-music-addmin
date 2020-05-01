package com.soft1851.music.admin.controller;

import com.soft1851.music.admin.annotation.ControllerWebLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author xunmi
 * @ClassName FileController
 * @Description TODO
 * @Date 2020/5/1
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/file")
public class FileController {

    @PostMapping("/upload")
    @ResponseBody
    @ControllerWebLog(name = "file", isSaved = true)
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String filePath = "C:\\Users\\Asus\\Desktop\\";
        File dest = new File(filePath + fileName);
        try {
            dest.createNewFile();
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败！";
    }
}

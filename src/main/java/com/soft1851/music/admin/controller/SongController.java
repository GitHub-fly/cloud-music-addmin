package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.annotation.ControllerWebLog;
import com.soft1851.music.admin.domain.entity.Song;
import com.soft1851.music.admin.service.SongService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/api/song")
public class SongController {

    @Resource
    private SongService songService;


    @GetMapping("/all")
    @ControllerWebLog(name = "song")
    public List<Song> allInfo(@Param("roleId") String roleId) {
        return songService.selectAll();
    }

    @GetMapping("/limit")
    @ControllerWebLog(name = "song")
    public List<Song> limitInfo(@Param("roleId") String roleId) {
        return songService.selectLimit();
    }

    @GetMapping(value = "/export")
    @ControllerWebLog(name = "song")
    public void exportData() {
        songService.exportData();
    }
}

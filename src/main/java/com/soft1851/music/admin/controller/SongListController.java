package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.annotation.ControllerWebLog;
import com.soft1851.music.admin.domain.dto.PageDto;
import com.soft1851.music.admin.domain.entity.SongList;
import com.soft1851.music.admin.service.SongListService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/api/songList")
public class SongListController {

    @Resource
    private SongListService songListService;

    @GetMapping("/all")
    @ControllerWebLog(name = "songList")
    public List<Map<String, Object>> allInfo(@Param("roleId") String roleId) {
        return songListService.getByType();
    }

    @PostMapping("/page")
    @ControllerWebLog(name = "songList")
    public List<SongList> getSongListByPage(@RequestBody PageDto pageDto) {
        return songListService.getByPage(pageDto);
    }

    @GetMapping("/blurSearch")
    @ControllerWebLog(name = "songList")
    public List<SongList> blurSearchInfo(@Param("key") String key) {
        return songListService.blurSelect(key);
    }

    @GetMapping(value = "/export")
    @ControllerWebLog(name = "songList")
    public void export() {
        songListService.exportData();
    }

}

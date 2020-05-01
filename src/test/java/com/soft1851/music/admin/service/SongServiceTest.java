package com.soft1851.music.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.soft1851.music.admin.domain.entity.Song;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author xunmi
 * @ClassName SongServiceTest
 * @Description TODO
 * @Date 2020/4/24
 * @Version 1.0
 **/
@SpringBootTest
class SongServiceTest {
    @Resource
    private SongService songService;

    @Test
    void count() {
        QueryWrapper<Song> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("singer", "黄");
        int count = songService.count(queryWrapper);
        System.out.println(count);
    }
    @Test
    void exportData() {
        songService.exportData();
    }
}

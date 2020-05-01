package com.soft1851.music.admin.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class SongListServiceTest {

    @Resource
    private SongListService songListService;

    @Test
    void getByType() {
        songListService.getByType().forEach(System.out::println);
    }
}
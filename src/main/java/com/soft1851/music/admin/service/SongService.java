package com.soft1851.music.admin.service;

import com.soft1851.music.admin.domain.entity.Song;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
public interface SongService extends IService<Song> {

    /**
     * 查找所有的歌曲
     * @return
     */
    List<Song> selectAll();

    /**
     * 获取前500条数据
     * @return
     */
    List<Song> selectLimit();

    /**
     * 导出数据
     */
    void exportData();
}
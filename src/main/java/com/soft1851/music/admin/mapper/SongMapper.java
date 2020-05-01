package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.domain.entity.Song;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xunmi
 * @since 2020-04-21
 */
public interface SongMapper extends BaseMapper<Song> {

    /**
     * 获取前500条数据
     * @return
     */
    @Select("SELECT * FROM song LIMIT 500")
    public List<Song> getLimit();
}

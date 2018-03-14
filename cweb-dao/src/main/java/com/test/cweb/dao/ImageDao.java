package com.test.cweb.dao;

import com.test.cweb.model.Image;
import com.test.cweb.model.ImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author hyl
 * @date 2018/02/25
 */
public interface ImageDao {
    int countByExample(ImageExample example);

    int deleteByExample(ImageExample example);

    int deleteByPrimaryKey(Integer pkId);

    int insert(Image record);

    int insertSelective(Image record);

    List<Image> selectByExample(ImageExample example);

    Image selectByPrimaryKey(Integer pkId);

    int updateByExampleSelective(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByExample(@Param("record") Image record, @Param("example") ImageExample example);

    int updateByPrimaryKeySelective(Image record);

    int updateByPrimaryKey(Image record);
}
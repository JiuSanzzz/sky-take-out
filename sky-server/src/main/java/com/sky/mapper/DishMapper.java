package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author dry
 * @version 1.0
 */
@Mapper
public interface DishMapper {
    /**
     * 基于分类id查询该分类下关联的菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(*) from sky_take_out.dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
}

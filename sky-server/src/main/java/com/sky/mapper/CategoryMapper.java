package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dry
 * @version 1.0
 */
@Mapper
public interface CategoryMapper {

    /**
     * 新增分类
     *
     * @param category
     */
    @Insert("insert into sky_take_out.category(type, name, sort, status" +
            ",create_time, update_time, create_user, update_user) values " +
            "(#{type},#{name},#{sort},#{status},#{createTime},#{updateTime}," +
            "#{createUser},#{updateUser})")
    void save(Category category);

    /**
     * 分页分类查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 删除分类
     *
     * @param id
     */
    @Delete("delete from sky_take_out.category where id = #{id}")
    void deleteById(Long id);

    /**
     * 修改分类
     *
     * @param category
     */
    void update(Category category);

    /**
     * 根据分类查询
     * @param type
     * @return
     */
    @Select("select * from sky_take_out.category where type = #{type}")
    List<Category> list(Integer type);
}

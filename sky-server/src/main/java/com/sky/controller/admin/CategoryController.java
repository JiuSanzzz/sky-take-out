package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dry
 * @version 1.0
 */
@Slf4j
@RestController      //接收前端请求注解
@RequestMapping("/admin/category") //统一的请求路径注解
@Api(tags = "分类管理相关接口")  //swagger 用来标注类的注解
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    /**
     * 新增分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类")
    public Result<String> save(@RequestBody CategoryDTO categoryDTO){    //@RequestBody 请求体注解
        log.info("新增分类:{}",categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * 分页分类查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页分类查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分页分类查询:{}",categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation("删除分类")
    public Result deleteById(Long id) {
        log.info("删除分类:{}",id);
        categoryService.deleteById(id);
        return Result.success();
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result update(CategoryDTO categoryDTO){
        log.info("修改分类");  //写日志是为了在控制台看到执行情况
        categoryService.update(categoryDTO);
        return Result.success();
    }


    /**
     * 启用禁用分类
     * @param id
     * @param status
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result startOrStop(Long id,@PathVariable Integer status){
        log.info("启用禁用分类:{}",id,status);
        categoryService.startOrStop(id,status);
        return Result.success();
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> list(Integer type){
        log.info("根据类型查询分类:{}",type);
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }

}

















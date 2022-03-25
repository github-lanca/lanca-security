package cn.lanca.v1.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.lanca.v1.entity.ShArea;
import cn.lanca.v1.service.ShAreaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>(ShArea)表控制层
 *
 * @author makejava
 * @since 2022-03-25 11:40:20
 */
@RestController
@RequestMapping("shArea")
public class ShAreaController {
    /**
     * 服务对象
     */
    @Resource
    private ShAreaService shAreaService;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param shArea 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ShArea> page, ShArea shArea) {
        return success(this.shAreaService.page(page, new QueryWrapper<>(shArea)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.shAreaService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param shArea 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ShArea shArea) {
        return success(this.shAreaService.save(shArea));
    }

    /**
     * 修改数据
     *
     * @param shArea 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ShArea shArea) {
        return success(this.shAreaService.updateById(shArea));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.shAreaService.removeByIds(idList));
    }
}


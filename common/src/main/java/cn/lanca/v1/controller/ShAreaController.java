package cn.lanca.v1.controller;

import cn.lanca.v1.entity.ShArea;
import cn.lanca.v1.service.ShAreaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (ShArea)表控制层
 *
 * @author makejava
 * @since 2022-03-28 10:53:36
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
     *      <p>我是p</p>
     *      <pre>我是pre</pre>
     *
     * @param a a
     * @param b a
     * @return
     */
    public ResponseEntity<String> xx(String a, String b) {

        return ResponseEntity.ok("");
    }

    /**
     * 分页查询
     *
     * @param shArea 筛选条件
     * @param of     of
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ShArea>> queryByPage(ShArea shArea, PageRequest of) {
        // pageRequest.withSort(Sort.Direction.DESC, "id");
//        PageRequest of = PageRequest.of(page, size);
        return ResponseEntity.ok(this.shAreaService.queryByPage(shArea, of));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ShArea> queryById(@PathVariable("id") Integer id) {
        ShArea shArea = this.shAreaService.queryById(id);
        return ResponseEntity.ok(shArea);
    }

    /**
     * 新增数据
     *
     * @param shArea 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ShArea> add(ShArea shArea) {
        return ResponseEntity.ok(this.shAreaService.insert(shArea));
    }

    /**
     * 编辑数据
     *
     * @param shArea 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ShArea> edit(ShArea shArea) {
        return ResponseEntity.ok(this.shAreaService.update(shArea));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.shAreaService.deleteById(id));
    }

}


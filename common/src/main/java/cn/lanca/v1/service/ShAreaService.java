package cn.lanca.v1.service;

import cn.lanca.v1.entity.ShArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ShArea)表服务接口
 *
 * @author makejava
 * @since 2022-03-28 10:53:37
 */
public interface ShAreaService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShArea queryById(Integer id);

    /**
     * 分页查询
     *
     * @param shArea      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<ShArea> queryByPage(ShArea shArea, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param shArea 实例对象
     * @return 实例对象
     */
    ShArea insert(ShArea shArea);

    /**
     * 修改数据
     *
     * @param shArea 实例对象
     * @return 实例对象
     */
    ShArea update(ShArea shArea);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}

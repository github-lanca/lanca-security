package cn.lanca.v1.service.impl;

import cn.lanca.v1.entity.ShArea;
import cn.lanca.v1.dao.ShAreaDao;
import cn.lanca.v1.service.ShAreaService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ShArea)表服务实现类
 *
 * @author makejava
 * @since 2022-03-28 10:53:37
 */
@Service("shAreaService")
public class ShAreaServiceImpl implements ShAreaService {
    @Resource
    private ShAreaDao shAreaDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShArea queryById(Integer id) {
        return this.shAreaDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param shArea      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<ShArea> queryByPage(ShArea shArea, PageRequest pageRequest) {
        long total = this.shAreaDao.count(shArea);
        return new PageImpl<>(this.shAreaDao.queryAllByLimit(shArea, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param shArea 实例对象
     * @return 实例对象
     */
    @Override
    public ShArea insert(ShArea shArea) {
        this.shAreaDao.insert(shArea);
        return shArea;
    }

    /**
     * 修改数据
     *
     * @param shArea 实例对象
     * @return 实例对象
     */
    @Override
    public ShArea update(ShArea shArea) {
        this.shAreaDao.update(shArea);
        return this.queryById(shArea.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.shAreaDao.deleteById(id) > 0;
    }
}

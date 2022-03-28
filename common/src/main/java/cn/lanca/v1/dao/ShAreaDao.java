package cn.lanca.v1.dao;

import cn.lanca.v1.entity.ShArea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (ShArea)表数据库访问层
 *
 * @author makejava
 * @since 2022-03-28 10:53:36
 */
@Mapper
public interface ShAreaDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShArea queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param shArea   查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<ShArea> queryAllByLimit(ShArea shArea, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shArea 查询条件
     * @return 总行数
     */
    long count(ShArea shArea);

    /**
     * 新增数据
     *
     * @param shArea 实例对象
     * @return 影响行数
     */
    int insert(ShArea shArea);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShArea> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShArea> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShArea> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShArea> entities);

    /**
     * 修改数据
     *
     * @param shArea 实例对象
     * @return 影响行数
     */
    int update(ShArea shArea);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}


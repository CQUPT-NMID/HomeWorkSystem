package cn.edu.cqupt.nmid.homeworksystem.dao;


import cn.edu.cqupt.nmid.homeworksystem.po.Source;
import cn.edu.cqupt.nmid.homeworksystem.po.model.SourceModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Source)表数据库访问层
 *
 * @author MaYunHao
 * @date 2020-04-14 16:53:46
 */

@Mapper
@Repository
public interface SourceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Source queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Source> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param source 实例对象
     * @return 对象列表
     */
    List<Source> queryAll(Source source);

    /**
     * 新增数据
     *
     * @param source 实例对象
     * @return 影响行数
     */
    int insert(Source source);

    /**
     * 修改数据
     *
     * @param source 实例对象
     * @return 影响行数
     */
    int update(Source source);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 通过学科id 查询数据
     * @param subjectId 学科id
     * @return
     */
    List<SourceModel> listSourcesBySubjectId(Integer subjectId);
}
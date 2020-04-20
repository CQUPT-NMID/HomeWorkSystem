package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.Homewoks;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HomewoksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Homewoks record);

    int insertSelective(Homewoks record);

    Homewoks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Homewoks record);

    int updateByPrimaryKey(Homewoks record);

    /**
     * 通过 课程id 查询作业
     * @param subjectId
     * @return
     */
    List<Homewoks> listHomeWorksBySubjectId(Integer subjectId);
}
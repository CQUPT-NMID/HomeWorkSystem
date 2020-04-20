package cn.edu.cqupt.nmid.homeworksystem.dao;

import cn.edu.cqupt.nmid.homeworksystem.po.Subjectclass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubjectclassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subjectclass record);

    int insertSelective(Subjectclass record);

    Subjectclass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subjectclass record);

    int updateByPrimaryKey(Subjectclass record);

    /**
     * 通过学科id 查询学科班级
     * @param subjectId
     * @return
     */
    List<Subjectclass> getSubjectClass(Integer subjectId);
}
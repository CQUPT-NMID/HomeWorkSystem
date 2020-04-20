package cn.edu.cqupt.nmid.homeworksystem.service;

import cn.edu.cqupt.nmid.homeworksystem.po.Homewoks;
import cn.edu.cqupt.nmid.homeworksystem.po.Source;
import cn.edu.cqupt.nmid.homeworksystem.po.model.SourceModel;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/4/10 15:15
 */
public interface SourceService {
    /**
     * 通过学科id 查询学科对应的资料
     * @param subjectId 学科id
     * @return
     */
    List<SourceModel> listSourcesBySubjectId(Integer subjectId);

    /**
     * 保存资源
     * @param source
     * @return 资源id
     */
    Integer saveSource(Source source);

    /**
     * 通过课程id 列出作业
     * @param subjectId 课程id
     * @return
     */
    List<Homewoks> listHomeWorksBySubjectId(Integer subjectId);

    /**
     * 保存作业信息
     * @param homewoks
     * @return
     */
    Integer publishHomeWork(Homewoks homewoks);
}

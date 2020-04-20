package cn.edu.cqupt.nmid.homeworksystem.service;

import cn.edu.cqupt.nmid.homeworksystem.po.Subject;
import cn.edu.cqupt.nmid.homeworksystem.po.Subjectclass;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/4/20 14:41
 */
public interface SubjectService {
    /**
     * 查询所有的 学科
     * @return
     */
    List<Subject> getAllSubject();

    /**
     * 通过学科id 获取所有班级
     * @param subjectId
     * @return
     */
    List<Subjectclass> getSubjectClassBySubjectId(Integer subjectId);
}

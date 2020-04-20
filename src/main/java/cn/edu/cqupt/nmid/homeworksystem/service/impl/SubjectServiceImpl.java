package cn.edu.cqupt.nmid.homeworksystem.service.impl;

import cn.edu.cqupt.nmid.homeworksystem.dao.SubjectMapper;
import cn.edu.cqupt.nmid.homeworksystem.dao.SubjectclassMapper;
import cn.edu.cqupt.nmid.homeworksystem.po.Subject;
import cn.edu.cqupt.nmid.homeworksystem.po.Subjectclass;
import cn.edu.cqupt.nmid.homeworksystem.service.SubjectService;
import cn.edu.cqupt.nmid.homeworksystem.web.SubjectController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/4/20 14:41
 */

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectMapper subjectMapper;
    private final SubjectclassMapper subjectclassMapper;

    public SubjectServiceImpl(SubjectMapper subjectMapper, SubjectclassMapper subjectclassMapper) {
        this.subjectMapper = subjectMapper;
        this.subjectclassMapper = subjectclassMapper;
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectMapper.selectAll();
    }

    @Override
    public List<Subjectclass> getSubjectClassBySubjectId(Integer subjectId) {
        return subjectclassMapper.getSubjectClass(subjectId);
    }
}

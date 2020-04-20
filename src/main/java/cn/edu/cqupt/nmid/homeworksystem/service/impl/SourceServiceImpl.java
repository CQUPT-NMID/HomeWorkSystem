package cn.edu.cqupt.nmid.homeworksystem.service.impl;

import cn.edu.cqupt.nmid.homeworksystem.dao.HomewoksMapper;
import cn.edu.cqupt.nmid.homeworksystem.dao.SourceDao;
import cn.edu.cqupt.nmid.homeworksystem.dao.SourceMapper;
import cn.edu.cqupt.nmid.homeworksystem.po.Homewoks;
import cn.edu.cqupt.nmid.homeworksystem.po.Source;
import cn.edu.cqupt.nmid.homeworksystem.po.model.SourceModel;
import cn.edu.cqupt.nmid.homeworksystem.service.SourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description 资源相关
 * @date 2020/4/10 15:16
 */

@Service
public class SourceServiceImpl implements SourceService {

    private final SourceMapper sourceMapper;

    private final SourceDao sourceDao;

    private final HomewoksMapper homewoksMapper;

    public SourceServiceImpl(SourceMapper sourceMapper, SourceDao sourceDao, HomewoksMapper homewoksMapper) {
        this.sourceMapper = sourceMapper;
        this.sourceDao = sourceDao;
        this.homewoksMapper = homewoksMapper;
    }

    @Override
    public List<SourceModel> listSourcesBySubjectId(Integer subjectId) {
        return sourceDao.listSourcesBySubjectId(subjectId);
    }

    @Override
    public Integer saveSource(Source source) {
        Assert.notNull(source,"source 资源不能为空");
        if (source.getPublishtime() == null){
            source.setPublishtime(new Date());
        }
        sourceDao.insert(source);
        return source.getId();
    }

    @Override
    public List<Homewoks> listHomeWorksBySubjectId(Integer subjectId) {
        return homewoksMapper.listHomeWorksBySubjectId(subjectId);
    }

    @Override
    public Integer publishHomeWork(Homewoks homewoks) {
        if (homewoks.getPublishtime() == null){
            homewoks.setPublishtime(new Date());
        }
        homewoksMapper.insertSelective(homewoks);
        return homewoks.getId();
    }
}

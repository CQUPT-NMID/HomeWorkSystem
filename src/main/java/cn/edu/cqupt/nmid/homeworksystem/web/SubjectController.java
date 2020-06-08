package cn.edu.cqupt.nmid.homeworksystem.web;

import cn.edu.cqupt.nmid.homeworksystem.po.Subject;
import cn.edu.cqupt.nmid.homeworksystem.po.Subjectclass;
import cn.edu.cqupt.nmid.homeworksystem.service.SubjectService;
import cn.edu.cqupt.nmid.homeworksystem.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/4/20 11:45
 */

@RestController
@Api(tags = "学科相关")
@RequestMapping("/api/subject")
public class SubjectController {


    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @ApiOperation("返回所有学科")
    @GetMapping
    public ResponseResult getAllSubject(){
        List<Subject> subjects = subjectService.getAllSubject();
        return ResponseResult.success(subjects);
    }

    @ApiOperation("返回所有学科班级")
    @GetMapping("/{id}")
    public ResponseResult getSubjectClass(@RequestParam @ApiParam(value = "学科id",required = true) Integer subjectId){
        List<Subjectclass> subjectclasses =  subjectService.getSubjectClassBySubjectId(subjectId);
        return ResponseResult.success(subjectclasses);
    }

}

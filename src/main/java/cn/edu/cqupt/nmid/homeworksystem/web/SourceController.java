package cn.edu.cqupt.nmid.homeworksystem.web;

import cn.edu.cqupt.nmid.homeworksystem.annotation.UserLogin;
import cn.edu.cqupt.nmid.homeworksystem.po.Homewoks;
import cn.edu.cqupt.nmid.homeworksystem.po.Source;
import cn.edu.cqupt.nmid.homeworksystem.po.model.SourceModel;
import cn.edu.cqupt.nmid.homeworksystem.service.SourceService;
import cn.edu.cqupt.nmid.homeworksystem.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/4/7 15:23
 */
@RestController
@Api(tags = "资源畅吧和作业")
@RequestMapping("/api/source")
public class SourceController {


    private final SourceService sourceService;

    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }



    @ApiOperation("获取学科的资源列表")
    @GetMapping
    public ResponseResult listSourcesBySubjectId(@RequestParam @ApiParam(value = "学科id", required = true) Integer subjectId) {
        List<SourceModel> sources = sourceService.listSourcesBySubjectId(subjectId);
        return ResponseResult.success(sources);
    }

    @ApiOperation("上传资源")
    @PostMapping
    public ResponseResult uploadSource(@RequestBody Source source) {
        Integer id = sourceService.saveSource(source);
        return ResponseResult.success(id);
    }

    @ApiOperation("列出作业")
    @GetMapping("/homeworks")
    public ResponseResult listHomeWorksBySubjectId(@RequestParam @ApiParam(value = "课程id",required = true) Integer subjectId){
      List<Homewoks> lists = sourceService.listHomeWorksBySubjectId(subjectId);
      return ResponseResult.success(lists);
    }

    @ApiOperation("发布作业: 教师")
    @PostMapping("/homeworks")
    public ResponseResult publishHomeWork(@RequestBody @ApiParam(value = "作业信息",required = true) Homewoks homewoks){
        Integer id = sourceService.publishHomeWork(homewoks);
        return ResponseResult.success(id);
    }


}

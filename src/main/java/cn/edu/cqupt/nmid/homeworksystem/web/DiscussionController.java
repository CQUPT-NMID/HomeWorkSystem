package cn.edu.cqupt.nmid.homeworksystem.web;

import cn.edu.cqupt.nmid.homeworksystem.annotation.UserLogin;
import cn.edu.cqupt.nmid.homeworksystem.enums.QuestionType;
import cn.edu.cqupt.nmid.homeworksystem.po.Answer;
import cn.edu.cqupt.nmid.homeworksystem.po.Question;
import cn.edu.cqupt.nmid.homeworksystem.po.model.AnswerModel;
import cn.edu.cqupt.nmid.homeworksystem.po.model.QuestionModel;
import cn.edu.cqupt.nmid.homeworksystem.po.vo.QuestionVo;
import cn.edu.cqupt.nmid.homeworksystem.service.DiscussionService;
import cn.edu.cqupt.nmid.homeworksystem.utils.ResponseResult;
import cn.edu.cqupt.nmid.homeworksystem.utils.TokenUser;
import cn.edu.cqupt.nmid.homeworksystem.utils.TokenUserUtil;
import cn.edu.cqupt.nmid.homeworksystem.utils.page.PageRequest;
import cn.edu.cqupt.nmid.homeworksystem.utils.page.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  论题空间相关接口
 * @date 2020/2/26 19:15
 */

@RestController
@Api(tags = "论题空间")
@RequestMapping("/discuss")
@UserLogin(required = true)
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @ApiOperation("发布问题:不支持更新,请谨慎填写")
    @PostMapping("/ques")
    public ResponseResult publishQuestion(@RequestBody @ApiParam(value = "问题",required = true) QuestionModel question){
        TokenUser user = TokenUserUtil.getTokenUser();
        Question questionDto = new Question();
        questionDto.setContent(question.getContent());
        questionDto.setUid(user.getId());
        questionDto.setSubjectId(question.getSubject());
        questionDto.setTitle(question.getTitle());
        Integer id = discussionService.publishQuestion(questionDto);
        return ResponseResult.success(id);
    }


    //-----------------查询问题相关内容-----------------------


    @ApiOperation("问题列表")
    @GetMapping("/ques")
    public ResponseResult listQuestions(@RequestParam(required = false,value = "学科id，如果不传则返回所有") Integer id,
                                        PageRequest page){
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<QuestionVo> list = discussionService.listQuetionsBySubjectId(id);
        PageResult result = new PageResult((Page) list);
        return ResponseResult.success(result);
    }


    @ApiOperation("通过问题id获取问题详情")
    @GetMapping("/ques/{id}")
    public ResponseResult getQuestion(@PathVariable Integer id){
        QuestionVo question = discussionService.getQuestionById(id);
        return ResponseResult.success(question);
    }

    //-----------------个人相关-----------------------

    //我的回答过的问题
    @ApiOperation("获取我的回答")
    @GetMapping("/ques/getMyAnswer")
    public ResponseResult getMyAnswer(@ApiParam(value = "学科id",required = false) Integer subjectId,
                                      PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        TokenUser user = TokenUserUtil.getTokenUser();
        List<QuestionVo> list = discussionService.getMyAnswer(subjectId,user.getId());
        PageResult result = new PageResult(list);
        return ResponseResult.success(result);
    }

    //我的提问的问题
    @ApiOperation("获取我的问题")
    @GetMapping("/ques/getMyQuestion")
    public ResponseResult getMyQuestion(@ApiParam(value = "学科id",required = false) Integer subjectId,
                                        PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        TokenUser user = TokenUserUtil.getTokenUser();
        List<QuestionVo> list = discussionService.getMyQuestion(subjectId,user.getId());
        PageResult result = new PageResult(list);
        return ResponseResult.success(result);
    }

    //我的足迹的问题
    @ApiOperation("获取我的足迹")
    @GetMapping("/ques/getMyHistory")
    public ResponseResult getMyHistory(@ApiParam(value = "学科id",required = false) Integer subjectId,
                                        PageRequest pageRequest){
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        TokenUser user = TokenUserUtil.getTokenUser();
        List<QuestionVo> list = discussionService.getMyHistory(subjectId,user.getId());
        PageResult result = new PageResult(list);
        return ResponseResult.success(result);
    }
    //设计
    //  放到列表请求里
    // get 请求 不封装
    // 参数
    // 1.学科id
    // 2. 分页
    // 3. 类型 default meQuestion answer history
    //技术要点
    //mybatis 选择查询 which where

    //多条件查询,我的相关问题

    @ApiOperation("获取与自己相关的问题")
    @GetMapping("/ques/history")
    public ResponseResult MyQuestion(@ApiParam(value = "学科id",required = false) Integer SubjectId,
                                     @ApiParam(value = "问题类型",required = false)QuestionType type,
                                     PageRequest pageRequest){
        TokenUser user = TokenUserUtil.getTokenUser();
        PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
        List<QuestionVo> list = discussionService.listQuestion(SubjectId,type,user.getId());
        return null;
    }


    //-----------------回答相关内容-----------------------

    @ApiOperation("通过问题id获取问题列表")
    @GetMapping("/answer/{id}/list")
    public ResponseResult listAnser(@PathVariable Integer id){
        List<AnswerModel> list = discussionService.listAnswerByQuestionId(id);
        return ResponseResult.success(list);
    }

    @ApiOperation("发表答案")
    @PostMapping("/answer")
    public ResponseResult publishAnswer(@RequestBody Answer answer){
        TokenUser tokenUser = TokenUserUtil.getTokenUser();
        answer.setUserId(tokenUser.getId());
        Integer id = discussionService.publishAnswer(answer);
        return ResponseResult.success(id);
    }

    @ApiOperation("修改答案")
    @PutMapping("/answer")
    public ResponseResult updateAnswer(@RequestBody Answer answer){
        TokenUser tokenUser = TokenUserUtil.getTokenUser();
        answer.setUserId(tokenUser.getId());
        Integer id = discussionService.updateAnswer(answer);
        return ResponseResult.success(id);
    }

    @ApiOperation("删除回答")
    @DeleteMapping("/answer/{id}")
    public ResponseResult deleteAnswer(@PathVariable Integer id){
        discussionService.deleteAnswer(id);
        return ResponseResult.success(id);
    }


}

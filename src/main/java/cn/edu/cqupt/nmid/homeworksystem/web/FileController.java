package cn.edu.cqupt.nmid.homeworksystem.web;

import cn.edu.cqupt.nmid.homeworksystem.annotation.UserLogin;
import cn.edu.cqupt.nmid.homeworksystem.service.SourceService;
import cn.edu.cqupt.nmid.homeworksystem.utils.CosUtil;
import cn.edu.cqupt.nmid.homeworksystem.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description
 * @date 2020/4/14 15:38
 */

@Controller
@Api(tags = "文件相关接口")
@UserLogin(required = true)
public class FileController {

    private final CosUtil cosUtil;

    private final Logger logger = LoggerFactory.getLogger(FileController.class);

    public FileController(CosUtil cosUtil) {
        this.cosUtil = cosUtil;
    }

    @ApiOperation("上传文件")
    @PostMapping("/file")
    public ResponseResult uploadFile(@ApiParam(value = "文件",required = true) MultipartFile[] files){
        Assert.notNull(files,"文件不能为空");
        List<String> urls = new ArrayList<>();
        for (MultipartFile file:files
             ) {
            String url = null;
            try {
                // 上传图片到cos
                // 根据文件的不同类型，上传到不同的文件夹内
                url = cosUtil.upload(file);
            } catch (IOException e) {
                logger.error("上传文件失败： {}",e.getMessage());
                return ResponseResult.failure("上传图片失败");
            }
            urls.add(url);
        }
        return ResponseResult.success(urls);
    }

}

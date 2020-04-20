package cn.edu.cqupt.nmid.homeworksystem.utils.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  分页返回结果
 * @date 2020/2/4 13:33
 */

public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;

    /**
     * 数据模型
     */
    private List<?> content;

    /**
     * 将pageInfo简化
     * @param pageInfo pageHelper的分页信息类
     */
    public PageResult(PageInfo pageInfo) {
        setPageNum(pageInfo.getPageNum());
        setPageSize(pageInfo.getPageSize());
        setTotalSize(pageInfo.getTotal());
        setContent(pageInfo.getList());
    }

    public PageResult(List list) {
        Page pageInfo = null;
        if (list instanceof Page) {
            pageInfo = (Page) list;
            setPageNum(pageInfo.getPageNum());
            setPageSize(pageInfo.getPageSize());
            setTotalSize(pageInfo.getTotal());
            setContent(list);
        }else{
            System.out.println("报错");
        }
    }

    public PageResult() {
    }

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public long getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }
    public List<?> getContent() {
        return content;
    }
    public void setContent(List<?> content) {
        this.content = content;
    }
}
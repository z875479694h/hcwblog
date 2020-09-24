package xyz.hcworld.hcwblog.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.hcworld.hcwblog.entity.Comment;
import xyz.hcworld.hcwblog.mapper.CommentMapper;
import xyz.hcworld.hcwblog.service.CommentService;
import xyz.hcworld.hcwblog.vo.CommentVo;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kenith-Zhang
 * @since 2020-07-12
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    /**
     * 获取文章评论
     * @param page 分页信息
     * @param postId 文章id
     * @param userId 用户id
     * @param order 排序信息
     * @return
     */
    @Override
    public IPage<CommentVo> paing(Page page, Long postId, Long userId, String order) {
        return commentMapper.selectComments(page,new QueryWrapper<Comment>()
                .eq(postId!=null,"post_id",postId)
                .eq(userId!=null,"user_id",userId)
                .orderByDesc(order!=null,order)
        );
    }

    @Override
    public List<CommentVo> ownComments(Long userId) {
        return commentMapper.selectOwnComments(new QueryWrapper<Comment>()
                .eq("c.user_id",userId)
                .gt("c.created", DateUtil.lastMonth())
                .orderByDesc("c.created"));
    }

}

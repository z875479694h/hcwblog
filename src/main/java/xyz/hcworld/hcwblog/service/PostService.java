package xyz.hcworld.hcwblog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import xyz.hcworld.hcwblog.entity.Post;
import xyz.hcworld.hcwblog.vo.PostVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kenith-Zhang
 * @since 2020-07-12
 */
public interface PostService extends IService<Post> {
    /**
     * 博客的分页信息
     * @param page 分页信息
     * @param categoryId 分类
     * @param userId 用户信息
     * @param level 置顶
     * @param recommend 精选
     * @param order 排序
     * @return
     */
    IPage paging(Page page, Long categoryId, Long userId, Integer level, Boolean recommend, String order);

    /**
     * 获取文章
     * @param wrapper
     * @return
     */
    PostVo selectOnePost(QueryWrapper<Post> wrapper);

    /**
     * 初始化本周热议
     */
    void initWeekRank();

    /**
     * 更新本周热议
     * @param key 那一天的key
     * @param post 要更新的文章
     */
    void upWeekRank(String key,Post post);
    /**
     *  评论数统计级加减
     * @param postId
     * @param isIncr
     */
    void incrCommentCountAndUnionForWeekRank(long postId ,boolean isIncr);

    /**
     *  删除文章
     * @param id 文章id
     * @param post 文章
     */
    void removePost(Long id,Post post);

    /**
     * 缓存文章基本信息
     * @param post
     * @param expireTime
     */
    void hashCachePostIdAndTitle(Post post, long expireTime);
    /**
     * 设置阅读量
     * @param vo
     */
    void setViewCount(PostVo vo);





}

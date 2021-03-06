package xyz.hcworld.hcwblog.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import xyz.hcworld.hcwblog.template.HotsTemplate;
import xyz.hcworld.hcwblog.template.PostsTemplate;
import xyz.hcworld.hcwblog.template.TimeAgoMethod;

import javax.annotation.PostConstruct;

/**
 * view层模板设置
 * @ClassName: FreemarkerConfig
 * @Author: 张红尘
 * @Date: 2020/7/13 23:25
 * @Version： 1.0
 */
@Configuration
public class FreemarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;
    @Autowired
    TimeAgoMethod timeAgoMethod;
    @Autowired
    PostsTemplate postsTemplate;
    @Autowired
    HotsTemplate hotsTemplate;

    /**
     * 自定义freemarker标签
     */
    @PostConstruct
    public void setUp() {
        configuration.setSharedVariable("timeAgo", timeAgoMethod);
        configuration.setSharedVariable("posts", postsTemplate);
        configuration.setSharedVariable("hots", hotsTemplate);
        configuration.setSharedVariable("shiro", new ShiroTags());
    }

}

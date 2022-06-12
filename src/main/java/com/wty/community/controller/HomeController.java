package com.wty.community.controller;

import com.wty.community.entity.DiscussPost;
import com.wty.community.entity.Page;
import com.wty.community.entity.User;
import com.wty.community.service.DiscussPostService;
import com.wty.community.service.UserService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className HomeController
 * @summary
 *      主页展示：
 *
 * @date 2022/06/03 15:15:17
 */
@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        // 方法调用前，SpringMVC会自动实例化Model和Page，并将Page注入Model，通过调试可以看到
        // 所以，在thymeleaf中可以自动访问Page对象中的数据，不需要再addAttribute
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost discussPost : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", discussPost);
                // 这里开始使用了 discussPost.getId()，导致user为空！！
                // 产生ThymeLeaf模板解析错误Exception evaluating SpringEL expression
                User user = userService.findUserById(discussPost.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }

    @RequestMapping(path="/error",method = RequestMethod.GET)
    public String getErrorPage() {
        return "/error/500";
    }

}

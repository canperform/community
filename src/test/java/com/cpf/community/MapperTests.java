package com.cpf.community;
import com.cpf.community.dao.DiscussPostMapper;
import com.cpf.community.dao.UserMapper;
import com.cpf.community.entity.DiscussPost;
import com.cpf.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){

        User user1 = userMapper.selectById(101);
        System.out.println(user1);

        User user2 = userMapper.selectByEmail("nowcoder102@sina.com");
        System.out.println(user2);

        User user3 = userMapper.selectByUsername("zhangfei");
        System.out.println(user3);

    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("123456");
        user.setSalt("123");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://images.cpf.com/101.png");
        user.setCreateTime(new Date());
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser(){
        int row1 = userMapper.updateStatus(150, 1);
        System.out.println(row1);

        int row2 = userMapper.updateHeaderUrl(150, "http://www.iii.com/102.png");
        System.out.println(row2);

        int row3 = userMapper.updatePassword(150, "aaa");
        System.out.println(row3);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost post : list){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

}

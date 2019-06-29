package com.neo.lesson2;

import com.neo.lesson2.comm.NeoProperties;
import com.neo.lesson2.comm.OtherProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
/*@Value("${neo.title}") 会默认读取 application.properties
或者 application.yml 文件中的 neo.title 配置属性值，并赋值给 title。
Assert.assertEquals 是判断属性值是否和目标值一致。*/
public class PropertiesTest {
    @Value("${neo.title}")
    private String title;
    @Test
    public void testSingle() {
        Assert.assertEquals(title, "剑剑");
    }
    @Resource
    private NeoProperties properties;
    @Resource
    private OtherProperties otherProperties;
    @Test
    public void testMore() throws Exception {
        System.out.println("title:"+properties.getTitle());
        System.out.println("description:"+properties.getDescription());
    }
    @Test
    public void testOther() throws Exception {
        System.out.println("title:"+otherProperties.getTitle());
        System.out.println("blog:"+otherProperties.getBlog());
    }
}

package com.mam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mam.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author Anmin
 * @Date 2022/11/28
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataRedisApplicationTest {

    @Resource
    private RedisTemplate redisTemplate;

    //Spring默认提供了一个StringRedisTemplate类，它的key和value的序列化方式默认就是String方式。省去了我们自定义RedisTemplate的过程
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void insertStrDataTest(){
        redisTemplate.opsForValue().set("name","小老弟");
        String name = (String)redisTemplate.opsForValue().get("name");
        System.out.println("name : "+ name);
    }

    @Test
    public void insertJsonDataTest(){
        redisTemplate.opsForValue().set("user:id",new User("小老弟",20));
        User user = (User)redisTemplate.opsForValue().get("user:id");
        System.out.println("name :" + user.getName() +",age :"+ user.getAge());

    }

    @Test
    public void insertJsonDataTest2(){
        try {
            // 1.创建一个Json序列化对象
            ObjectMapper objectMapper = new ObjectMapper();
            // 2.将要存入的对象通过Json序列化对象转换为字符串
            String userJson1 = objectMapper.writeValueAsString(new User("小白", 21));
            // 3.通过StringRedisTemplate将数据存入redis
            stringRedisTemplate.opsForValue().set("user:100",userJson1);
            // 4.通过key取出value
            String userJson2 = stringRedisTemplate.opsForValue().get("user:100");
            // 5.由于取出的值是String类型的Json字符串，因此我们需要通过Json序列化对象来转换为java对象
            User user = objectMapper.readValue(userJson2, User.class);
            // 6.打印结果
            System.out.println("name :" + user.getName() +",age :"+ user.getAge());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

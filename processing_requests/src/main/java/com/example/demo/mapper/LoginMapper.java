package com.example.demo.mapper;

import com.example.demo.dao.Option;
import com.example.demo.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//数据库调用接口
//在xml配置文件中设置对应SQL语句
@Mapper
public interface LoginMapper {
    //@Param的作用就是给参数命名，在mapper里面某方法A（int id），
    // 当添加注解后A（@Param("userId") int id），也就是说外部想要取出传入的id值，
    // 只需要取它的参数名userId就可以了。将参数值传如SQL语句中，通过#{userId}进行取值给SQL的参数赋值。
    List<User> selectByUserName(@Param("username") String username);//根据用户名寻找用户
    List<User>selectByUser(@Param("user")User user);//根据User类寻找用户


}

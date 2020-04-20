package cn.ivanlu.market.dao;

import cn.ivanlu.market.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {
    @Select("select * from tm_user where id = #{id}")
    User getUserById(long id);

    @Select("select * from tm_user where username=#{username} limit 1")
    User getUserByUsername(String username);

    @Select("select * from tm_user where token=#{token} limit 1")
    User getUserByToken(String token);

    @Select("select count(1) from tm_user")
    int count();

    @Select("select * from tm_user order by id limit #{size} offset #{st}")
    List<User> getUsersByPage(@Param("st") int start, @Param("size") int size);

    @Insert("insert into tm_user(username,password,email,phone,create_time,role_id) values (#{username},#{password},#{email},#{phone},#{createTime},#{roleId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(User user);

    @Update("update tm_user set token=#{token},update_time=#{updateTime},expire=#{expire} where id=#{id}")
    int updateToken(User user);
}

package cn.ivanlu.market.dao;

import cn.ivanlu.market.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {
    @Select("select * from user where id = #{id}")
    User getUserById(long id);

    @Select("select * from user where username=#{username} limit 1")
    User getUserByUsername(String username);
}

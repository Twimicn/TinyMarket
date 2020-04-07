package cn.ivanlu.market.dao;

import cn.ivanlu.market.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {
    @Select("select * from tm_user where id = #{id}")
    User getUserById(long id);

    @Select("select * from tm_user where username=#{username} limit 1")
    User getUserByUsername(String username);
}

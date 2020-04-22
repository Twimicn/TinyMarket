package cn.ivanlu.market.dao;

import cn.ivanlu.market.model.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CategoryDao {
    @Insert("insert into tm_category(name,parent_id,create_time) values (#{name},#{pid},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long create(Category category);

    @Update("update tm_category set name=#{name} where id=#{id}")
    int updateName(long id, String name);

    @Select("select count(1) from tm_category")
    int count();

    @Select("select * from tm_category order by id limit #{size} offset #{st}")
    List<Category> listByPage(@Param("st") int start, @Param("size") int size);

    @Select("select count(1) from tm_category where parent_id=#{pid}")
    int countByPid(long pid);

    @Select("select * from tm_category where parent_id=#{pid} order by id limit #{size} offset #{st}")
    List<Category> listByPidAndPage(long pid, @Param("st") int start, @Param("size") int size);
}

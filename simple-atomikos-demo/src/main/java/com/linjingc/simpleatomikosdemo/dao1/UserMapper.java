package com.linjingc.simpleatomikosdemo.dao1;

import com.linjingc.simpleatomikosdemo.entity.BasicUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

/**
 * @author cxc
 */
@Component
@Mapper
public interface UserMapper {
	@Insert("INSERT INTO user(id,name) VALUES(#{id},#{name})")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public void insert(BasicUser user);
	/**
	 * 需要注意的内容
	 * #{name} 和${name}的区别    #{}代表自动拼接``  ${}表示需要手动添加``
	 */
}

package com.zyh.code.mapper;

import com.zyh.code.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyh.code.support.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户表 Mapper接口
 *
 * @author zyh
 * @since 2024-07-09
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询用户表
     *
     * @return
     */
    List<UserVO> selectUserList();
}

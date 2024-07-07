package com.zyh.code.mapper;

import com.zyh.code.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyh.code.support.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Mapper接口
 *
 * @author zyh
 * @since 2024-07-07
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询
     *
     * @return
     */
    List<UserVO> selectUserList();
}

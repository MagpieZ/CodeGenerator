package com.zyh.code.mapper;

import com.zyh.code.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyh.code.support.vo.AccountVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  Mapper接口
 *
 * @author zyh
 * @since 2024-07-08
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * 查询
     *
     * @return
     */
    List<AccountVO> selectAccountList();
}

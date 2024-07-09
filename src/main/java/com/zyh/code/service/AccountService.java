package com.zyh.code.service;

import com.zyh.code.support.dto.AccountDTO;
import com.zyh.code.support.dto.query.AccountQueryDTO;
import com.zyh.code.support.vo.AccountVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

/**
 * 账户表 前端控制器
 *
 * @author zyh
 * @since 2024-07-09
 */
public interface AccountService {

    /**
     * 分页
     *
     * @param pageable
     * @param queryDto
     * @return
     */
    Page<AccountVO> page(Pageable pageable, AccountQueryDTO queryDto);

    /**
     * 列表
     *
     * @param sort
     * @param queryDto
     * @return
     */
    List<AccountVO> list(Sort sort, AccountQueryDTO queryDto);

    /**
     * 保存
     *
     * @param dto
     */
    void save(AccountDTO dto);

    /**
     * 更新
     *
     * @param dto
     */
    void update(AccountDTO dto);

    /**
     * 查看
     *
     * @param id
     * @return
     */
    AccountVO get(String id);

    /**
     * 删除
     *
     * @param ids
     */
    void delete(Set<String> ids);
    }

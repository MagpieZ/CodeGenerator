package com.zyh.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyh.code.mapper.AccountMapper;
import com.zyh.code.entity.Account;
import com.zyh.code.service.AccountService;
import com.zyh.code.support.dto.AccountDTO;
import com.zyh.code.support.dto.query.AccountQueryDTO;
import com.zyh.code.support.vo.AccountVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 服务实现类
 *
 * @author zyh
 * @since 2024-07-07
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Transactional(readOnly = true)
    @Override
    public List<AccountVO> page(Pageable pageable, AccountQueryDTO queryDto) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountVO> list(Sort sort, AccountQueryDTO queryDto) {
        QueryWrapper<Account> queryWrapper = this.buildQuery(queryDto);
        return this.transferVo(this.accountMapper.selectList(queryWrapper));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(AccountDTO dto) {
        // TODO 唯一性字段校验
        dto.setUserId(null);
        accountMapper.insert(this.transferEntity(null, dto));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(AccountDTO dto) {
        Assert.hasText(dto.getUserId(), "id不能为空");
        // TODO 唯一性字段校验
        Account entity = accountMapper.selectById(dto.getUserId());
        Assert.notNull(entity, "找不到id为 " + dto.getUserId() + " 的记录");
        accountMapper.updateById(this.transferEntity(entity, dto));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Set<String> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            accountMapper.deleteBatchIds(ids);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public AccountVO get(String id) {
        Assert.hasText(id, "id不能为空");
        Account entity = accountMapper.selectById(id);
        Assert.notNull(entity, "找不到id为 " + id + " 的记录");
        return this.transferVo(entity);
    }

    private QueryWrapper<Account> buildQuery(AccountQueryDTO queryDto) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        if (Objects.nonNull(queryDto)) {
            queryWrapper.lambda().eq(StringUtils.isNotBlank(queryDto.getUserId()), Account::getUserId, queryDto.getUserId());
        }
        return queryWrapper;
    }

    private Account transferEntity(Account entity, AccountDTO dto) {
        if (Objects.isNull(entity)) {
            entity = new Account();
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private List<AccountVO> transferVo(List<Account> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }

        List<AccountVO> voList = entities.stream().map(entity -> {
            AccountVO vo = new AccountVO();
            BeanUtils.copyProperties(entity, vo);
            return vo;
        }).collect(Collectors.toList());
        return voList;
    }

    private AccountVO transferVo(Account entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        AccountVO vo = new AccountVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }
}

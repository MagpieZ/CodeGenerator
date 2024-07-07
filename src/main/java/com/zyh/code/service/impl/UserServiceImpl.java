package com.zyh.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyh.code.mapper.UserMapper;
import com.zyh.code.entity.User;
import com.zyh.code.service.UserService;
import com.zyh.code.support.dto.UserDTO;
import com.zyh.code.support.dto.query.UserQueryDTO;
import com.zyh.code.support.vo.UserVO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public List<UserVO> page(Pageable pageable, UserQueryDTO queryDto) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserVO> list(Sort sort, UserQueryDTO queryDto) {
        QueryWrapper<User> queryWrapper = this.buildQuery(queryDto);
        return this.transferVo(this.userMapper.selectList(queryWrapper));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(UserDTO dto) {
        // TODO 唯一性字段校验
        dto.setId(null);
        userMapper.insert(this.transferEntity(null, dto));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(UserDTO dto) {
        Assert.hasText(String.valueOf(dto.getId()), "id不能为空");
        // TODO 唯一性字段校验
        User entity = userMapper.selectById(dto.getId());
        Assert.notNull(entity, "找不到id为 " + dto.getId() + " 的记录");
        userMapper.updateById(this.transferEntity(entity, dto));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Set<String> ids) {
        if (Objects.isNull(ids)) {
            userMapper.deleteBatchIds(ids);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public UserVO get(String id) {
        Assert.hasText(id, "id不能为空");
        User entity = userMapper.selectById(id);
        Assert.notNull(entity, "找不到id为 " + id + " 的记录");
        return this.transferVo(entity);
    }

    private QueryWrapper<User> buildQuery(UserQueryDTO queryDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (ObjectUtils.isNotEmpty(queryDto)) {
            queryWrapper.lambda().eq(StringUtils.isNotBlank(String.valueOf(queryDto.getId())), User::getId, queryDto.getId());
        }
        return queryWrapper;
    }

    private User transferEntity(User entity, UserDTO dto) {
        if (Objects.isNull(entity)) {
            entity = new User();
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    private List<UserVO> transferVo(List<User> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }

        List<UserVO> voList = entities.stream().map(entity -> {
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(entity, vo);
            return vo;
        }).collect(Collectors.toList());
        return voList;
    }

    private UserVO transferVo(User entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }
}

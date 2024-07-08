package com.zyh.code.service;

import org.springframework.data.domain.Page;
import com.zyh.code.support.dto.UserDTO;
import com.zyh.code.support.dto.query.UserQueryDTO;
import com.zyh.code.support.vo.UserVO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

/**
 * 前端控制器
 *
 * @author zyh
 * @since 2024-07-07
 */
public interface UserService {

    /**
     * 分页
     *
     * @param pageable
     * @param queryDto
     * @return
     */
    Page<UserVO> page(Pageable pageable, UserQueryDTO queryDto);

    /**
     * 列表
     *
     * @param sort
     * @param queryDto
     * @return
     */
    List<UserVO> list(Sort sort, UserQueryDTO queryDto);

    /**
     * 保存
     *
     * @param dto
     */
    void save(UserDTO dto);

    /**
     * 更新
     *
     * @param dto
     */
    void update(UserDTO dto);

    /**
     * 查看
     *
     * @param id
     * @return
     */
    UserVO get(String id);

    /**
     * 删除
     *
     * @param ids
     */
    void delete(Set<String> ids);
}

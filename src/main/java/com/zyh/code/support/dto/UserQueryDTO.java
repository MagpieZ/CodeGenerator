package com.zyh.code.support.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;

import com.zyh.code.entity.User;

/**
 * 用户表 查询条件
 *
 * @author zyh
 * @since 2024-07-09
 */
@Data
@Schema(description = "用户表")
public class UserQueryDTO extends User {
    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Long id;
}

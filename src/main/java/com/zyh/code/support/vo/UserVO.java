package com.zyh.code.support.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;

import com.zyh.code.entity.User;

/**
 * @author zyh
 * @since 2024-07-07
 */
@Data
@Schema(description = "")
public class UserVO extends User {
    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Long id;
    /**
     * 名字
     */
    @Schema(description = "名字")
    private String name;
    /**
     * 总额度
     */
    @Schema(description = "总额度")
    private Integer age;
    /**
     * 性别
     */
    @Schema(description = "性别")
    private Integer gender;
    /**
     * 余额
     */
    @Schema(description = "余额")
    private Long phone;
    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private Date createTime;
    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private Date updateTime;
}

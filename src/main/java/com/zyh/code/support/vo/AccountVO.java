package com.zyh.code.support.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;

import com.zyh.code.entity.Account;

/**
 * 账户表
 *
 * @author zyh
 * @since 2024-07-09
 */
@Data
@Schema(description = "账户表")
public class AccountVO extends Account{
    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private String id;
    /**
     * 总额度
     */
    @Schema(description = "总额度")
    private Integer total;
    /**
     * 已用账户余额
     */
    @Schema(description = "已用账户余额")
    private Integer used;
    /**
     * 余额
     */
    @Schema(description = "余额")
    private Integer residue;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "创建时间")
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "修改时间")
    private Date updateTime;
}

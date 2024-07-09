package com.zyh.code.support.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;

import com.zyh.code.entity.Account;

/**
 * @author zyh
 * @since 2024-07-08
 */
@Data
@Schema(description = "")
public class AccountVO extends Account {
    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private String userId;
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
    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}

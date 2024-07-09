package com.zyh.code.support.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

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
public class AccountDTO extends Account {
    /**
     * 总额度
     */
    @Schema(description = "总额度 total")
    private Integer total;
    /**
     * 已用账户余额
     */
    @Schema(description = "已用账户余额 used")
    private Integer used;
    /**
     * 余额
     */
    @Schema(description = "余额 residue")
    private Integer residue;
}

package com.zyh.code.support.dto.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;

import com.zyh.code.entity.Account;

/**
 *  查询条件
 *
 * @author zyh
 * @since 2024-07-07
 */
@Data
@Schema(description = "")
public class AccountQueryDTO extends Account {
}

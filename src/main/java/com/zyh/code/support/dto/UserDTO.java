package com.zyh.code.support.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;

import com.zyh.code.entity.User;

/**
 * 
 *
 * @author zyh
 * @since 2024-07-07
 */
@Data
@Schema(description = "")
public class UserDTO extends User {
                /**
                 * 名字
                 */
            @Schema(description = "名字 name")
            private String name;
                /**
                 * 总额度
                 */
            @Schema(description = "总额度 age")
            private Integer age;
                /**
                 * 性别
                 */
            @Schema(description = "性别 gender")
            private Integer gender;
                /**
                 * 余额
                 */
            @Schema(description = "余额 phone")
            private Long phone;
}

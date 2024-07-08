package com.zyh.code.controller;

import org.springframework.data.domain.Page;
import com.zyh.code.service.UserService;
import com.zyh.code.support.dto.UserDTO;
import com.zyh.code.support.dto.query.UserQueryDTO;
import com.zyh.code.support.vo.UserVO;
import com.zyh.utils.ActionResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 *  前端控制器
 *
 * @author zyh
 * @since 2024-07-07
 */
@Tag(name = "", description = "UserController")
@Validated
@CrossOrigin
@RestController
@RequestMapping("cloud/sample/api/v1/user")
public class UserController {

    @Autowired
    private UserService  userService;

    /**
     * 分页查询
     *
     * @param pageable
     * @return
     */
    @Operation(summary = "分页")
    @RequestMapping(value = "/page", method = {RequestMethod.POST, RequestMethod.GET})
    public ActionResult<Page<UserVO>>page(@ParameterObject @PageableDefault(sort = "createTime", direction = Sort.Direction.DESC) Pageable pageable,
                                          @ParameterObject UserQueryDTO queryDto){
        return ActionResult.success(userService.page(pageable,queryDto));
    }

    /**
     * 列表查询
     *
     * @param sort
     * @return
     */
    @Operation(summary = "列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public ActionResult<List<UserVO>>list(@ParameterObject @SortDefault(sort = "createTime", direction = Sort.Direction.DESC) Sort sort,
        @ParameterObject UserQueryDTO queryDto){
        return ActionResult.success(userService.list(sort,queryDto));
    }

    /**
     * 保存
     *
     * @param dto
     * @return
     */
    @Operation(summary = "保存")
    @PostMapping("/save")
    public ActionResult<Void> save(@Validated @RequestBody UserDTO dto){
         userService.save(dto);
        return ActionResult.success();
    }

    /**
     * 修改
     *
     * @param dto
     * @return
     */
    @Operation(summary = "修改")
    @PostMapping(value = "/update")
    public ActionResult<Void> update(@Validated @RequestBody UserDTO dto){
        userService.update(dto);
        return ActionResult.success();
    }

    /**
     * 查询详情
     *
     * @param id
     * @return
     */
    @Operation(summary = "查询详情")
    @GetMapping("/get")
    public ActionResult<UserVO> get(@Parameter(description = "记录ID") @RequestParam String id){
        return ActionResult.success(userService.get(id));
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public ActionResult<Void> delete(@RequestParam Set<String> ids){
        userService.delete(ids);
        return ActionResult.success("删除成功");
    }
}

package com.zyh.code.controller;

import com.zyh.code.service.AccountService;
import com.zyh.code.support.dto.AccountDTO;
import com.zyh.code.support.dto.query.AccountQueryDTO;
import com.zyh.code.support.vo.AccountVO;
import com.zyh.utils.ActionResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
 * @since 2024-07-08
 */
@Tag(name = "", description = "AccountController")
@Validated
@CrossOrigin
@RestController
@RequestMapping("cloud/sample/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService  accountService;

    /**
     * 分页查询
     *
     * @param pageable
     * @return
     */
    @Operation(summary = "分页")
    @RequestMapping(value = "/page", method = {RequestMethod.POST, RequestMethod.GET})
    public ActionResult<Page<AccountVO>>page(@ParameterObject @PageableDefault(sort = "createTime", direction = Sort.Direction.DESC) Pageable pageable,
        @ParameterObject AccountQueryDTO queryDto){
        return ActionResult.success(accountService.page(pageable,queryDto));
    }

    /**
     * 列表查询
     *
     * @param sort
     * @return
     */
    @Operation(summary = "列表")
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public ActionResult<List<AccountVO>>list(@ParameterObject @SortDefault(sort = "createTime", direction = Sort.Direction.DESC) Sort sort,
        @ParameterObject AccountQueryDTO queryDto){
        return ActionResult.success(accountService.list(sort,queryDto));
    }

    /**
     * 保存
     *
     * @param dto
     * @return
     */
    @Operation(summary = "保存")
    @PostMapping("/save")
    public ActionResult<Void> save(@Validated @RequestBody AccountDTO dto){
         accountService.save(dto);
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
    public ActionResult<Void> update(@Validated @RequestBody AccountDTO dto){
        accountService.update(dto);
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
    public ActionResult<AccountVO> get(@Parameter(description = "记录ID") @RequestParam String id){
        return ActionResult.success(accountService.get(id));
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    public ActionResult<Void> delete(@RequestParam Set<String> ids){
        accountService.delete(ids);
        return ActionResult.success("删除成功");
    }
}

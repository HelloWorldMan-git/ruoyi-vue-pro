package cn.iocoder.yudao.module.decs.controller.admin.rule;

import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.constraints.*;
import jakarta.validation.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.decs.controller.admin.rule.vo.*;
import cn.iocoder.yudao.module.decs.dal.dataobject.rule.DecsRuleDO;
import cn.iocoder.yudao.module.decs.service.rule.DecsRuleService;

@Tag(name = "管理后台 - 决策点")
@RestController
@RequestMapping("/decs/rule")
@Validated
public class DecsRuleController {

    @Resource
    private DecsRuleService ruleService;

    @PostMapping("/create")
    @Operation(summary = "创建决策点")
    @PreAuthorize("@ss.hasPermission('decs:rule:create')")
    public CommonResult<Long> createRule(@Valid @RequestBody DecsRuleSaveReqVO createReqVO) {
        return success(ruleService.createRule(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新决策点")
    @PreAuthorize("@ss.hasPermission('decs:rule:update')")
    public CommonResult<Boolean> updateRule(@Valid @RequestBody DecsRuleSaveReqVO updateReqVO) {
        ruleService.updateRule(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除决策点")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('decs:rule:delete')")
    public CommonResult<Boolean> deleteRule(@RequestParam("id") Long id) {
        ruleService.deleteRule(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得决策点")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('decs:rule:query')")
    public CommonResult<DecsRuleRespVO> getRule(@RequestParam("id") Long id) {
        DecsRuleDO rule = ruleService.getRule(id);
        return success(BeanUtils.toBean(rule, DecsRuleRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得决策点分页")
    @PreAuthorize("@ss.hasPermission('decs:rule:query')")
    public CommonResult<PageResult<DecsRuleRespVO>> getRulePage(@Valid DecsRulePageReqVO pageReqVO) {
        PageResult<DecsRuleDO> pageResult = ruleService.getRulePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, DecsRuleRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出决策点 Excel")
    @PreAuthorize("@ss.hasPermission('decs:rule:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRuleExcel(@Valid DecsRulePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<DecsRuleDO> list = ruleService.getRulePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "决策点.xls", "数据", DecsRuleRespVO.class,
                        BeanUtils.toBean(list, DecsRuleRespVO.class));
    }

}
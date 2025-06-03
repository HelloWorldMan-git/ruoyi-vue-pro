package cn.iocoder.yudao.module.decs.controller.admin.execact;

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

import cn.iocoder.yudao.module.decs.controller.admin.execact.vo.*;
import cn.iocoder.yudao.module.decs.dal.dataobject.execact.DecsExecActDO;
import cn.iocoder.yudao.module.decs.service.execact.DecsExecActService;

@Tag(name = "管理后台 - 执行动作")
@RestController
@RequestMapping("/decs/exec-act")
@Validated
public class DecsExecActController {

    @Resource
    private DecsExecActService execActService;

    @PostMapping("/create")
    @Operation(summary = "创建执行动作")
    @PreAuthorize("@ss.hasPermission('decs:exec-act:create')")
    public CommonResult<Long> createExecAct(@Valid @RequestBody DecsExecActSaveReqVO createReqVO) {
        return success(execActService.createExecAct(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新执行动作")
    @PreAuthorize("@ss.hasPermission('decs:exec-act:update')")
    public CommonResult<Boolean> updateExecAct(@Valid @RequestBody DecsExecActSaveReqVO updateReqVO) {
        execActService.updateExecAct(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除执行动作")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('decs:exec-act:delete')")
    public CommonResult<Boolean> deleteExecAct(@RequestParam("id") Long id) {
        execActService.deleteExecAct(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得执行动作")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('decs:exec-act:query')")
    public CommonResult<DecsExecActRespVO> getExecAct(@RequestParam("id") Long id) {
        DecsExecActDO execAct = execActService.getExecAct(id);
        return success(BeanUtils.toBean(execAct, DecsExecActRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得执行动作分页")
    @PreAuthorize("@ss.hasPermission('decs:exec-act:query')")
    public CommonResult<PageResult<DecsExecActRespVO>> getExecActPage(@Valid DecsExecActPageReqVO pageReqVO) {
        PageResult<DecsExecActDO> pageResult = execActService.getExecActPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, DecsExecActRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出执行动作 Excel")
    @PreAuthorize("@ss.hasPermission('decs:exec-act:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportExecActExcel(@Valid DecsExecActPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<DecsExecActDO> list = execActService.getExecActPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "执行动作.xls", "数据", DecsExecActRespVO.class,
                        BeanUtils.toBean(list, DecsExecActRespVO.class));
    }

}
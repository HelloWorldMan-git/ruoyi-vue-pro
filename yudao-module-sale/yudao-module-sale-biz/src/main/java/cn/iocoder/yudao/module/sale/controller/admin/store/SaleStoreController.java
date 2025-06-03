package cn.iocoder.yudao.module.sale.controller.admin.store;

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

import cn.iocoder.yudao.module.sale.controller.admin.store.vo.*;
import cn.iocoder.yudao.module.sale.dal.dataobject.store.SaleStoreDO;
import cn.iocoder.yudao.module.sale.dal.dataobject.item.SaleItemDO;
import cn.iocoder.yudao.module.sale.service.store.SaleStoreService;

@Tag(name = "管理后台 - 店铺")
@RestController
@RequestMapping("/sale/store")
@Validated
public class SaleStoreController {

    @Resource
    private SaleStoreService storeService;

    @PostMapping("/create")
    @Operation(summary = "创建店铺")
    @PreAuthorize("@ss.hasPermission('sale:store:create')")
    public CommonResult<Long> createStore(@Valid @RequestBody SaleStoreSaveReqVO createReqVO) {
        return success(storeService.createStore(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新店铺")
    @PreAuthorize("@ss.hasPermission('sale:store:update')")
    public CommonResult<Boolean> updateStore(@Valid @RequestBody SaleStoreSaveReqVO updateReqVO) {
        storeService.updateStore(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除店铺")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('sale:store:delete')")
    public CommonResult<Boolean> deleteStore(@RequestParam("id") Long id) {
        storeService.deleteStore(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得店铺")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('sale:store:query')")
    public CommonResult<SaleStoreRespVO> getStore(@RequestParam("id") Long id) {
        SaleStoreDO store = storeService.getStore(id);
        return success(BeanUtils.toBean(store, SaleStoreRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得店铺分页")
    @PreAuthorize("@ss.hasPermission('sale:store:query')")
    public CommonResult<PageResult<SaleStoreRespVO>> getStorePage(@Valid SaleStorePageReqVO pageReqVO) {
        PageResult<SaleStoreDO> pageResult = storeService.getStorePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, SaleStoreRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出店铺 Excel")
    @PreAuthorize("@ss.hasPermission('sale:store:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportStoreExcel(@Valid SaleStorePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<SaleStoreDO> list = storeService.getStorePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "店铺.xls", "数据", SaleStoreRespVO.class,
                        BeanUtils.toBean(list, SaleStoreRespVO.class));
    }

    // ==================== 子表（商品） ====================

    @GetMapping("/item/page")
    @Operation(summary = "获得商品分页")
    @Parameter(name = "storeId", description = "店铺id")
    @PreAuthorize("@ss.hasPermission('sale:store:query')")
    public CommonResult<PageResult<SaleItemDO>> getItemPage(PageParam pageReqVO,
                                                                                        @RequestParam("storeId") Long storeId) {
        return success(storeService.getItemPage(pageReqVO, storeId));
    }

    @PostMapping("/item/create")
    @Operation(summary = "创建商品")
    @PreAuthorize("@ss.hasPermission('sale:store:create')")
    public CommonResult<Long> createItem(@Valid @RequestBody SaleItemDO item) {
        return success(storeService.createItem(item));
    }

    @PutMapping("/item/update")
    @Operation(summary = "更新商品")
    @PreAuthorize("@ss.hasPermission('sale:store:update')")
    public CommonResult<Boolean> updateItem(@Valid @RequestBody SaleItemDO item) {
        storeService.updateItem(item);
        return success(true);
    }

    @DeleteMapping("/item/delete")
    @Parameter(name = "id", description = "编号", required = true)
    @Operation(summary = "删除商品")
    @PreAuthorize("@ss.hasPermission('sale:store:delete')")
    public CommonResult<Boolean> deleteItem(@RequestParam("id") Long id) {
        storeService.deleteItem(id);
        return success(true);
    }

	@GetMapping("/item/get")
	@Operation(summary = "获得商品")
	@Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('sale:store:query')")
	public CommonResult<SaleItemDO> getItem(@RequestParam("id") Long id) {
	    return success(storeService.getItem(id));
	}

}
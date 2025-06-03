package cn.iocoder.yudao.module.system.controller.admin.brand;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.module.system.controller.admin.user.vo.user.UserSimpleRespVO;
import cn.iocoder.yudao.module.system.convert.user.UserConvert;
import cn.iocoder.yudao.module.system.dal.dataobject.brand.BrandUserDO;
import cn.iocoder.yudao.module.system.dal.dataobject.dept.DeptDO;
import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

import cn.iocoder.yudao.module.system.controller.admin.brand.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.brand.BrandDO;
import cn.iocoder.yudao.module.system.service.brand.BrandService;

@Tag(name = "管理后台 - 品牌")
@RestController
@RequestMapping("/system/brand")
@Validated
public class BrandController {

    @Resource
    private BrandService brandService;

    @PostMapping("/create")
    @Operation(summary = "创建品牌")
    @PreAuthorize("@ss.hasPermission('system:brand:create')")
    public CommonResult<Long> createBrand(@Valid @RequestBody BrandSaveReqVO createReqVO) {
        return success(brandService.createBrand(createReqVO));
    }


    @PutMapping("/update")
    @Operation(summary = "更新品牌")
    @PreAuthorize("@ss.hasPermission('system:brand:update')")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<Boolean> updateBrand(@Valid @RequestBody BrandSaveReqVO updateReqVO) {
        brandService.updateBrand(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除品牌")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:brand:delete')")
    public CommonResult<Boolean> deleteBrand(@RequestParam("id") Long id) {
        brandService.deleteBrand(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得品牌")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:brand:query')")
    public CommonResult<BrandRespVO> getBrand(@RequestParam("id") Long id) {
        return success(brandService.getBrand(id));
    }

    @GetMapping("/page")
    @Operation(summary = "获得品牌分页")
    @PreAuthorize("@ss.hasPermission('system:brand:query')")
    public CommonResult<PageResult<BrandRespVO>> getBrandPage(@Valid BrandPageReqVO pageReqVO) {
        PageResult<BrandDO> pageResult = brandService.getBrandPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BrandRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出品牌 Excel")
    @PreAuthorize("@ss.hasPermission('system:brand:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportBrandExcel(@Valid BrandPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<BrandDO> list = brandService.getBrandPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "品牌.xls", "数据", BrandRespVO.class,
                        BeanUtils.toBean(list, BrandRespVO.class));
    }

    @GetMapping({"/list-all-simple", "/simple-list"})
    @Operation(summary = "获取品牌精简信息列表", description = "只包含被开启的品牌，主要用于前端的下拉选项")
    public CommonResult<List<BrandDO>> getSimpleBrandList(Integer my) {
        return success(brandService.getListByStateAndMy(CommonStatusEnum.ENABLE.getStatus(),my));
    }

    // ==================== 子表（品牌的参与者） ====================

    @GetMapping("/brand-user/page")
    @Operation(summary = "获得品牌的参与者分页")
    @Parameter(name = "brandId", description = "品牌ID")
    @PreAuthorize("@ss.hasPermission('system:brand:query')")
    public CommonResult<PageResult<BrandUserDO>> getBrandUserPage(PageParam pageReqVO,
                                                                  @RequestParam("brandId") Long brandId) {
        return success(brandService.getBrandUserPage(pageReqVO, brandId));
    }

    @PostMapping("/brand-user/create")
    @Operation(summary = "创建品牌的参与者")
    @PreAuthorize("@ss.hasPermission('system:brand:create')")
    public CommonResult<Long> createBrandUser(@Valid @RequestBody BrandUserDO brandUser) {

        return success(brandService.createBrandUser(brandUser));
    }

    @PutMapping("/brand-user/update")
    @Operation(summary = "更新品牌的参与者")
    @PreAuthorize("@ss.hasPermission('system:brand:update')")
    public CommonResult<Boolean> updateBrandUser(@Valid @RequestBody BrandUserDO brandUser) {
        brandService.updateBrandUser(brandUser);
        return success(true);
    }

    @DeleteMapping("/brand-user/delete")
    @Parameter(name = "id", description = "编号", required = true)
    @Operation(summary = "删除品牌的参与者")
    @PreAuthorize("@ss.hasPermission('system:brand:delete')")
    public CommonResult<Boolean> deleteBrandUser(@RequestParam("id") Long id) {
        brandService.deleteBrandUser(id);
        return success(true);
    }

    @GetMapping("/brand-user/get")
    @Operation(summary = "获得品牌的参与者")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('system:brand:query')")
    public CommonResult<BrandUserDO> getBrandUser(@RequestParam("id") Long id) {
        return success(brandService.getBrandUser(id));
    }


}
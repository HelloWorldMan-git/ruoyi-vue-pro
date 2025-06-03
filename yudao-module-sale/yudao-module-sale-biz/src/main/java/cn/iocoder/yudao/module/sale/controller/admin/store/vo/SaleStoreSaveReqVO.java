package cn.iocoder.yudao.module.sale.controller.admin.store.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;
import cn.iocoder.yudao.module.sale.dal.dataobject.item.SaleItemDO;

@Schema(description = "管理后台 - 店铺新增/修改 Request VO")
@Data
public class SaleStoreSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "15293")
    private Long id;

    @Schema(description = "店铺电商ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "17638")
    @NotEmpty(message = "店铺电商ID不能为空")
    private String eid;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotEmpty(message = "名称不能为空")
    private String name;

    @Schema(description = "主页", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "主页不能为空")
    private String home;

    @Schema(description = "电商平台", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "电商平台不能为空")
    private String eplate;

    @Schema(description = "品牌ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "30055")
    @NotNull(message = "品牌ID不能为空")
    private Long brandId;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "状态不能为空")
    private Integer state;

    @Schema(description = "是否采集销售数据", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否采集销售数据不能为空")
    private Integer grabSale;

}
package cn.iocoder.yudao.module.sale.controller.admin.store.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 店铺 Response VO")
@Data
@ExcelIgnoreUnannotated
public class SaleStoreRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "15293")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "店铺电商ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "17638")
    @ExcelProperty("店铺电商ID")
    private String eid;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("名称")
    private String name;

    @Schema(description = "主页", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("主页")
    private String home;

    @Schema(description = "电商平台", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "电商平台", converter = DictConvert.class)
    @DictFormat("system_eplate") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private String eplate;

    @Schema(description = "品牌ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "30055")
    @ExcelProperty("品牌ID")
    private Long brandId;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("状态")
    private Integer state;

    @Schema(description = "是否采集销售数据", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "是否采集销售数据", converter = DictConvert.class)
    @DictFormat("common_yesno") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer grabSale;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
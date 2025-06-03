package cn.iocoder.yudao.module.sale.controller.admin.store.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 店铺分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SaleStorePageReqVO extends PageParam {

    @Schema(description = "店铺电商ID", example = "17638")
    private String eid;

    @Schema(description = "名称", example = "芋艿")
    private String name;

    @Schema(description = "主页")
    private String home;

    @Schema(description = "电商平台")
    private String eplate;

    @Schema(description = "品牌ID", example = "30055")
    private Long brandId;

    @Schema(description = "状态")
    private Integer state;

    @Schema(description = "是否采集销售数据")
    private Integer grabSale;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
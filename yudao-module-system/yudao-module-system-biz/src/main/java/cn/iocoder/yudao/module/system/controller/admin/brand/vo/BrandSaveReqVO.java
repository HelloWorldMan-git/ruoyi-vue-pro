package cn.iocoder.yudao.module.system.controller.admin.brand.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 品牌新增/修改 Request VO")
@Data
public class BrandSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "名称不能为空")
    private String name;

    @Schema(description = "是否我的", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否我的不能为空")
    private Integer my;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "状态不能为空")
    private Integer state;

    @Schema(description = "内容平台列表", example = "1,3,5")
    private Set<String> plateIds = Collections.emptySet(); // 兜底

}
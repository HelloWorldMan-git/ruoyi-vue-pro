package cn.iocoder.yudao.module.decs.controller.admin.rule.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 决策点新增/修改 Request VO")
@Data
public class DecsRuleSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "10961")
    private Long id;

    @Schema(description = "决策维度", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "决策维度不能为空")
    private Integer dimension;

    @Schema(description = "内容账号ID", example = "2476")
    private Long uperId;

    @Schema(description = "作品ID", example = "23797")
    private Long workId;

    @Schema(description = "决策场景", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "决策场景不能为空")
    private Integer scene;

    @Schema(description = "对比周期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "对比周期不能为空")
    private Integer period;

    @Schema(description = "基础量")
    private Long base;

    @Schema(description = "变化量")
    private Long variety;

    @Schema(description = "变化百分比")
    private Integer percent;

}
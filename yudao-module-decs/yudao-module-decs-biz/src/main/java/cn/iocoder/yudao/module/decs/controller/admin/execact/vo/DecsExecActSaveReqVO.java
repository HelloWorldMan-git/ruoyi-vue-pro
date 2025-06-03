package cn.iocoder.yudao.module.decs.controller.admin.execact.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 执行动作新增/修改 Request VO")
@Data
public class DecsExecActSaveReqVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "635")
    private Long id;

    @Schema(description = "分类", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "分类不能为空")
    private Integer actClass;

    @Schema(description = "动作内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "动作内容不能为空")
    private String action;

    @Schema(description = "执行规格")
    private String spec;

}
package cn.iocoder.yudao.module.decs.controller.admin.execact.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 执行动作 Response VO")
@Data
@ExcelIgnoreUnannotated
public class DecsExecActRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "635")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "分类", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "分类", converter = DictConvert.class)
    @DictFormat("desc_act_class") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer actClass;

    @Schema(description = "动作内容", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("动作内容")
    private String action;

    @Schema(description = "执行规格")
    @ExcelProperty("执行规格")
    private String spec;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
package cn.iocoder.yudao.module.decs.controller.admin.rule.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 决策点 Response VO")
@Data
@ExcelIgnoreUnannotated
public class DecsRuleRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "10961")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "决策维度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "决策维度", converter = DictConvert.class)
    @DictFormat("desc_dimen") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer dimension;

    @Schema(description = "内容账号ID", example = "2476")
    @ExcelProperty("内容账号ID")
    private Long uperId;

    @Schema(description = "作品ID", example = "23797")
    @ExcelProperty("作品ID")
    private Long workId;

    @Schema(description = "决策场景", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "决策场景", converter = DictConvert.class)
    @DictFormat("desc_scene") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer scene;

    @Schema(description = "对比周期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("对比周期")
    private Integer period;

    @Schema(description = "基础量")
    @ExcelProperty("基础量")
    private Long base;

    @Schema(description = "变化量")
    @ExcelProperty("变化量")
    private Long variety;

    @Schema(description = "变化百分比")
    @ExcelProperty("变化百分比")
    private Integer percent;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
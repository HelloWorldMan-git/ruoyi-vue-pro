package cn.iocoder.yudao.module.decs.controller.admin.rule.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 决策点分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DecsRulePageReqVO extends PageParam {

    @Schema(description = "决策维度")
    private Integer dimension;

    @Schema(description = "内容账号ID", example = "2476")
    private Long uperId;

    @Schema(description = "作品ID", example = "23797")
    private Long workId;

    @Schema(description = "决策场景")
    private Integer scene;

    @Schema(description = "对比周期")
    private Integer period;

    @Schema(description = "基础量")
    private Long base;

    @Schema(description = "变化量")
    private Long variety;

    @Schema(description = "变化百分比")
    private Integer percent;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
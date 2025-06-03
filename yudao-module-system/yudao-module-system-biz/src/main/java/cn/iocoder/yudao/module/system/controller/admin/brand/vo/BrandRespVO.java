package cn.iocoder.yudao.module.system.controller.admin.brand.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 品牌 Response VO")
@Data
@ExcelIgnoreUnannotated
public class BrandRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("名称")
    private String name;

    @Schema(description = "是否我的", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty(value = "是否我的", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_YESNO)
    private Integer my;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("状态")
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer state;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

    @Schema(description = "内容平台列表", example = "1,3,5")
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<Long> plateIds; // 兜底

}
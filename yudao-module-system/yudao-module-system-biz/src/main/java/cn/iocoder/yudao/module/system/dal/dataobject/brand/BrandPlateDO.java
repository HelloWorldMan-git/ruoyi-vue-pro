package cn.iocoder.yudao.module.system.dal.dataobject.brand;

import com.fhs.core.trans.vo.TransPojo;
import lombok.*;

import java.io.Serializable;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 品牌的内容平台 DO
 *
 * @author 芋道源码
 */
@TableName("brand_plate")
@KeySequence("brand_plate_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandPlateDO extends BaseDO {

    /**
     * 品牌ID
     */
    private Long brandId;
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 内容平台
     *
     * 枚举 { system_plate }
     */
    private String plate;

}
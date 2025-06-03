package cn.iocoder.yudao.module.sale.dal.dataobject.store;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 店铺 DO
 *
 * @author 凸透镜
 */
@TableName("sale_store")
@KeySequence("sale_store_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleStoreDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 店铺电商ID
     */
    private String eid;
    /**
     * 名称
     */
    private String name;
    /**
     * 主页
     */
    private String home;
    /**
     * 电商平台
     *
     * 枚举 {@link TODO system_eplate 对应的类}
     */
    private String eplate;
    /**
     * 品牌ID
     */
    private Long brandId;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 是否采集销售数据
     *
     * 枚举 {@link TODO common_yesno 对应的类}
     */
    private Integer grabSale;

}
package cn.iocoder.yudao.module.sale.dal.dataobject.item;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 商品 DO
 *
 * @author 凸透镜
 */
@TableName("sale_item")
@KeySequence("sale_item_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleItemDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 商品电商ID
     */
    private String eid;
    /**
     * 店铺id
     */
    private Long storeId;
    /**
     * 名称
     */
    private String title;
    /**
     * 主页
     */
    private String home;
    /**
     * 状态
     *
     * 枚举 {@link TODO sys_state 对应的类}
     */
    private Integer state;
    /**
     * 是否采集销售数据
     *
     * 枚举 {@link TODO common_yesno 对应的类}
     */
    private Integer grabSale;

}
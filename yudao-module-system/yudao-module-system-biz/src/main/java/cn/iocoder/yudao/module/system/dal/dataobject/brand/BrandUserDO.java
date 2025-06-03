package cn.iocoder.yudao.module.system.dal.dataobject.brand;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 品牌的参与者 DO
 *
 * @author 凸透镜
 */
@TableName("brand_user")
@KeySequence("brand_user_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandUserDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 品牌ID
     */
    private Long brandId;
    /**
     * 参与者类型
     *
     * 枚举 {@link TODO desc_user_type 对应的类}
     */
    private Integer userType;
    /**
     * 参与者ID
     */
    private Long userId;

}
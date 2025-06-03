package cn.iocoder.yudao.module.decs.dal.dataobject.rule;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 决策点 DO
 *
 * @author 芋道源码
 */
@TableName("decs_rule")
@KeySequence("decs_rule_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DecsRuleDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 决策维度
     *
     * 枚举 { desc_dimen 对应的类}
     */
    private Integer dimension;
    /**
     * 内容账号ID
     */
    private Long uperId;
    /**
     * 作品ID
     */
    private Long workId;
    /**
     * 决策场景
     *
     * 枚举 { desc_scene 对应的类}
     */
    private Integer scene;
    /**
     * 对比周期
     */
    private Integer period;
    /**
     * 基础量
     */
    private Long base;
    /**
     * 变化量
     */
    private Long variety;
    /**
     * 变化百分比
     */
    private Integer percent;

}
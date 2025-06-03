package cn.iocoder.yudao.module.decs.dal.dataobject.execact;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 执行动作 DO
 *
 * @author 凸透镜
 */
@TableName("decs_exec_act")
@KeySequence("decs_exec_act_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DecsExecActDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 分类
     *
     * 枚举 {@link  desc_act_class 对应的类}
     */
    private Integer actClass;
    /**
     * 动作内容
     */
    private String action;
    /**
     * 执行规格
     */
    private String spec;

}
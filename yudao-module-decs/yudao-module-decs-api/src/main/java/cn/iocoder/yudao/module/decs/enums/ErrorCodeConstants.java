package cn.iocoder.yudao.module.decs.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Report 错误码枚举类
 *
 * report 系统，使用 1-003-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 决策中心 模块 1-003-000-000 ==========
    ErrorCode EXEC_ACT_NOT_EXISTS = new ErrorCode(1_010_000_000, "动作分类不存在");
    ErrorCode RULE_NOT_EXISTS = new ErrorCode(1_010_000_001, "决策点不存在");

}

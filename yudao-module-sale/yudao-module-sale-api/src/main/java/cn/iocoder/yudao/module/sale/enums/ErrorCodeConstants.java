package cn.iocoder.yudao.module.sale.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Report 错误码枚举类
 *
 * report 系统，使用 1-011-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 销量分析 模块 1-010-000-000 ==========
    ErrorCode STORE_NOT_EXISTS = new ErrorCode(1_011_000_000, "店铺不存在");
    ErrorCode ITEM_NOT_EXISTS = new ErrorCode(1_011_000_001, "商品不存在");

}

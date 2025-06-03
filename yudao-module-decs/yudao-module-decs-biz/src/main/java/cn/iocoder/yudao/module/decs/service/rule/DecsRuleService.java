package cn.iocoder.yudao.module.decs.service.rule;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.decs.controller.admin.rule.vo.*;
import cn.iocoder.yudao.module.decs.dal.dataobject.rule.DecsRuleDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 决策点 Service 接口
 *
 * @author 芋道源码
 */
public interface DecsRuleService {

    /**
     * 创建决策点
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRule(@Valid DecsRuleSaveReqVO createReqVO);

    /**
     * 更新决策点
     *
     * @param updateReqVO 更新信息
     */
    void updateRule(@Valid DecsRuleSaveReqVO updateReqVO);

    /**
     * 删除决策点
     *
     * @param id 编号
     */
    void deleteRule(Long id);

    /**
     * 获得决策点
     *
     * @param id 编号
     * @return 决策点
     */
    DecsRuleDO getRule(Long id);

    /**
     * 获得决策点分页
     *
     * @param pageReqVO 分页查询
     * @return 决策点分页
     */
    PageResult<DecsRuleDO> getRulePage(DecsRulePageReqVO pageReqVO);

}
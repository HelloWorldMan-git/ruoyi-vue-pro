package cn.iocoder.yudao.module.decs.service.rule;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.decs.controller.admin.rule.vo.*;
import cn.iocoder.yudao.module.decs.dal.dataobject.rule.DecsRuleDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.decs.dal.mysql.rule.DecsRuleMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.decs.enums.ErrorCodeConstants.*;

/**
 * 决策点 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class DecsRuleServiceImpl implements DecsRuleService {

    @Resource
    private DecsRuleMapper ruleMapper;

    @Override
    public Long createRule(DecsRuleSaveReqVO createReqVO) {
        // 插入
        DecsRuleDO rule = BeanUtils.toBean(createReqVO, DecsRuleDO.class);
        ruleMapper.insert(rule);
        // 返回
        return rule.getId();
    }

    @Override
    public void updateRule(DecsRuleSaveReqVO updateReqVO) {
        // 校验存在
        validateRuleExists(updateReqVO.getId());
        // 更新
        DecsRuleDO updateObj = BeanUtils.toBean(updateReqVO, DecsRuleDO.class);
        ruleMapper.updateById(updateObj);
    }

    @Override
    public void deleteRule(Long id) {
        // 校验存在
        validateRuleExists(id);
        // 删除
        ruleMapper.deleteById(id);
    }

    private void validateRuleExists(Long id) {
        if (ruleMapper.selectById(id) == null) {
            throw exception(RULE_NOT_EXISTS);
        }
    }

    @Override
    public DecsRuleDO getRule(Long id) {
        return ruleMapper.selectById(id);
    }

    @Override
    public PageResult<DecsRuleDO> getRulePage(DecsRulePageReqVO pageReqVO) {
        return ruleMapper.selectPage(pageReqVO);
    }

}
package cn.iocoder.yudao.module.decs.dal.mysql.rule;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.decs.dal.dataobject.rule.DecsRuleDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.decs.controller.admin.rule.vo.*;

/**
 * 决策点 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface DecsRuleMapper extends BaseMapperX<DecsRuleDO> {

    default PageResult<DecsRuleDO> selectPage(DecsRulePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DecsRuleDO>()
                .eqIfPresent(DecsRuleDO::getDimension, reqVO.getDimension())
                .eqIfPresent(DecsRuleDO::getUperId, reqVO.getUperId())
                .eqIfPresent(DecsRuleDO::getWorkId, reqVO.getWorkId())
                .eqIfPresent(DecsRuleDO::getScene, reqVO.getScene())
                .eqIfPresent(DecsRuleDO::getPeriod, reqVO.getPeriod())
                .eqIfPresent(DecsRuleDO::getBase, reqVO.getBase())
                .eqIfPresent(DecsRuleDO::getVariety, reqVO.getVariety())
                .eqIfPresent(DecsRuleDO::getPercent, reqVO.getPercent())
                .betweenIfPresent(DecsRuleDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DecsRuleDO::getId));
    }

}
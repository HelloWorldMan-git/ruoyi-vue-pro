package cn.iocoder.yudao.module.decs.dal.mysql.execact;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.decs.dal.dataobject.execact.DecsExecActDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.decs.controller.admin.execact.vo.*;

/**
 * 执行动作 Mapper
 *
 * @author 凸透镜
 */
@Mapper
public interface DecsExecActMapper extends BaseMapperX<DecsExecActDO> {

    default PageResult<DecsExecActDO> selectPage(DecsExecActPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<DecsExecActDO>()
                .eqIfPresent(DecsExecActDO::getActClass, reqVO.getClass())
                .eqIfPresent(DecsExecActDO::getAction, reqVO.getAction())
                .eqIfPresent(DecsExecActDO::getSpec, reqVO.getSpec())
                .betweenIfPresent(DecsExecActDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(DecsExecActDO::getId));
    }

}
package cn.iocoder.yudao.module.system.dal.mysql.brand;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.brand.BrandDO;
import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.system.controller.admin.brand.vo.*;

/**
 * 品牌 Mapper
 *
 * @author 凸透镜
 */
@Mapper
public interface BrandMapper extends BaseMapperX<BrandDO> {

    default PageResult<BrandDO> selectPage(BrandPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BrandDO>()
                .likeIfPresent(BrandDO::getName, reqVO.getName())
                .eqIfPresent(BrandDO::getMy, reqVO.getMy())
                .eqIfPresent(BrandDO::getState, reqVO.getState())
                .betweenIfPresent(BrandDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BrandDO::getId));
    }

    default List<BrandDO> selectListByStateAndMy(Integer state, Integer my) {
        return selectList(new LambdaQueryWrapperX<BrandDO>()
                .eq(BrandDO::getState, state)
                .eq(BrandDO::getMy, my));
    }

}
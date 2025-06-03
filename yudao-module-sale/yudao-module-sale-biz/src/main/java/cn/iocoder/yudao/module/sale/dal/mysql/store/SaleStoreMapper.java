package cn.iocoder.yudao.module.sale.dal.mysql.store;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.sale.dal.dataobject.store.SaleStoreDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.sale.controller.admin.store.vo.*;

/**
 * 店铺 Mapper
 *
 * @author 凸透镜
 */
@Mapper
public interface SaleStoreMapper extends BaseMapperX<SaleStoreDO> {

    default PageResult<SaleStoreDO> selectPage(SaleStorePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SaleStoreDO>()
                .eqIfPresent(SaleStoreDO::getEid, reqVO.getEid())
                .likeIfPresent(SaleStoreDO::getName, reqVO.getName())
                .eqIfPresent(SaleStoreDO::getHome, reqVO.getHome())
                .eqIfPresent(SaleStoreDO::getEplate, reqVO.getEplate())
                .eqIfPresent(SaleStoreDO::getBrandId, reqVO.getBrandId())
                .eqIfPresent(SaleStoreDO::getState, reqVO.getState())
                .eqIfPresent(SaleStoreDO::getGrabSale, reqVO.getGrabSale())
                .betweenIfPresent(SaleStoreDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SaleStoreDO::getId));
    }

}
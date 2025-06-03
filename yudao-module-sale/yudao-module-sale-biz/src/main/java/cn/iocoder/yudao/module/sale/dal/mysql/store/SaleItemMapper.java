package cn.iocoder.yudao.module.sale.dal.mysql.item;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.sale.dal.dataobject.item.SaleItemDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品 Mapper
 *
 * @author 凸透镜
 */
@Mapper
public interface SaleItemMapper extends BaseMapperX<SaleItemDO> {

    default PageResult<SaleItemDO> selectPage(PageParam reqVO, Long storeId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SaleItemDO>()
            .eq(SaleItemDO::getStoreId, storeId)
            .orderByDesc(SaleItemDO::getId));
    }

    default int deleteByStoreId(Long storeId) {
        return delete(SaleItemDO::getStoreId, storeId);
    }

}
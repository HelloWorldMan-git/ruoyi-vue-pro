package cn.iocoder.yudao.module.system.dal.mysql.brand;

import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.brand.BrandPlateDO;
import cn.iocoder.yudao.module.system.dal.dataobject.dept.UserPostDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * 品牌的内容平台 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface BrandPlateMapper extends BaseMapperX<BrandPlateDO> {


    default List<BrandPlateDO> selectListByBrandId(Long brandId) {
        return selectList(BrandPlateDO::getBrandId, brandId);
    }


    default void deleteByBrandIdAndPlateId(Long brandId, Collection<String> plateIds) {
        delete(new LambdaQueryWrapperX<BrandPlateDO>()
                .eq(BrandPlateDO::getBrandId, brandId)
                .in(BrandPlateDO::getPlate, plateIds));
    }

    default void deleteByBrandId(Long brandId) {
        delete(new LambdaQueryWrapperX<BrandPlateDO>()
                .eq(BrandPlateDO::getBrandId, brandId));
    }


}
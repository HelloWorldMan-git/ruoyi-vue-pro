package cn.iocoder.yudao.module.system.dal.mysql.brand;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.system.dal.dataobject.brand.BrandUserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌的参与者 Mapper
 *
 * @author 凸透镜
 */
@Mapper
public interface BrandUserMapper extends BaseMapperX<BrandUserDO> {

    default PageResult<BrandUserDO> selectPage(PageParam reqVO, Long brandId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BrandUserDO>()
            .eq(BrandUserDO::getBrandId, brandId)
            .orderByDesc(BrandUserDO::getId));
    }

    default int deleteByBrandId(Long brandId) {
        return delete(BrandUserDO::getBrandId, brandId);
    }

}
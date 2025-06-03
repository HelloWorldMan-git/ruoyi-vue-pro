package cn.iocoder.yudao.module.system.service.brand;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.dict.core.DictFrameworkUtils;
import cn.iocoder.yudao.module.system.controller.admin.brand.vo.BrandPageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.brand.vo.BrandRespVO;
import cn.iocoder.yudao.module.system.controller.admin.brand.vo.BrandSaveReqVO;
import cn.iocoder.yudao.module.system.dal.dataobject.brand.BrandDO;
import cn.iocoder.yudao.module.system.dal.dataobject.brand.BrandPlateDO;
import cn.iocoder.yudao.module.system.dal.dataobject.brand.BrandUserDO;
import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
import cn.iocoder.yudao.module.system.dal.mysql.brand.BrandMapper;
import cn.iocoder.yudao.module.system.dal.mysql.brand.BrandPlateMapper;
import cn.iocoder.yudao.module.system.dal.mysql.brand.BrandUserMapper;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import jakarta.annotation.Resource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;

/**
 * 品牌 Service 实现类
 *
 * @author 凸透镜
 */
@Service
@Validated
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Resource
    private BrandPlateMapper brandPlateMapper;

    @Resource
    private BrandUserMapper brandUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createBrand(BrandSaveReqVO createReqVO) {
        // 1.插入品牌
        BrandDO brand = BeanUtils.toBean(createReqVO, BrandDO.class);
        brandMapper.insert(brand);
        // 2.插入品牌的内容平台
        if (CollectionUtil.isNotEmpty(createReqVO.getPlateIds())) {
            brandPlateMapper.insertBatch(convertList(createReqVO.getPlateIds(),
                    plate -> new BrandPlateDO().setBrandId(brand.getId()).setPlate(plate)));
        }
        // 返回
        return brand.getId();
    }

    @Override
    public void updateBrand(BrandSaveReqVO updateReqVO) {
        // 校验存在
        validateBrandExists(updateReqVO.getId());
        // 更新
        BrandDO updateObj = BeanUtils.toBean(updateReqVO, BrandDO.class);
        brandMapper.updateById(updateObj);
        updateBrandPlate(updateReqVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBrand(Long id) {
        // 校验存在
        validateBrandExists(id);
        // 删除
        brandMapper.deleteById(id);
        brandPlateMapper.deleteByBrandId(id);
        brandUserMapper.deleteByBrandId(id);
    }

    private void validateBrandExists(Long id) {
        if (brandMapper.selectById(id) == null) {
            throw exception(BRAND_NOT_EXISTS);
        }
    }

    @Override
    public BrandRespVO getBrand(Long id) {
        Set<String> plateIds = convertSet(brandPlateMapper.selectListByBrandId(id), BrandPlateDO::getPlate);
        BrandDO brand = brandMapper.selectById(id);
        BrandRespVO brandRespVO = BeanUtils.toBean(brand, BrandRespVO.class);
        brandRespVO.setPlateIds(convertSet(plateIds,Long::valueOf));
        return brandRespVO;
    }

    @Override
    public PageResult<BrandDO> getBrandPage(BrandPageReqVO pageReqVO) {
        return brandMapper.selectPage(pageReqVO);
    }


    private void updateBrandPlate(BrandSaveReqVO reqVO) {
        Long brandId = reqVO.getId();
        Set<String> dbPlateIds = convertSet(brandPlateMapper.selectListByBrandId(brandId), BrandPlateDO::getPlate);
        // 计算新增和删除的岗位编号
        Set<String> plateIds = CollUtil.emptyIfNull(reqVO.getPlateIds());
        Collection<String> createPlateIds = CollUtil.subtract(plateIds, dbPlateIds);
        Collection<String> deletePlateIds = CollUtil.subtract(dbPlateIds, plateIds);
        // 执行新增和删除。对于已经授权的岗位，不用做任何处理
        if (!CollectionUtil.isEmpty(createPlateIds)) {
            brandPlateMapper.insertBatch(convertList(createPlateIds,
                    plate -> new BrandPlateDO().setBrandId(brandId).setPlate(plate)));
        }
        if (!CollectionUtil.isEmpty(deletePlateIds)) {
            brandPlateMapper.deleteByBrandIdAndPlateId(brandId, deletePlateIds);
        }
    }

    // ==================== 子表（品牌的参与者） ====================

    @Override
    public PageResult<BrandUserDO> getBrandUserPage(PageParam pageReqVO, Long brandId) {
        return brandUserMapper.selectPage(pageReqVO, brandId);
    }

    @Override
    public Long createBrandUser(BrandUserDO brandUser) {
        try {
            brandUserMapper.insert(brandUser);
        }catch(DuplicateKeyException e){
            throw exception(BRAND_USER_IS_EXISTS, DictFrameworkUtils.getDictDataLabel(DictTypeConstants.DESC_USER_TYPE, brandUser.getUserType()));
        }
        return brandUser.getId();
    }

    @Override
    public void updateBrandUser(BrandUserDO brandUser) {
        // 校验存在
        validateBrandUserExists(brandUser.getId());
        // 更新
        brandUser.setUpdater(null).setUpdateTime(null); // 解决更新情况下：updateTime 不更新
        brandUserMapper.updateById(brandUser);
    }

    @Override
    public void deleteBrandUser(Long id) {
        // 校验存在
        validateBrandUserExists(id);
        // 删除
        brandUserMapper.deleteById(id);
    }

    @Override
    public BrandUserDO getBrandUser(Long id) {
        return brandUserMapper.selectById(id);
    }

    private void validateBrandUserExists(Long id) {
        if (brandUserMapper.selectById(id) == null) {
            throw exception(BRAND_USER_NOT_EXISTS);
        }
    }

    private void deleteBrandUserByBrandId(Long brandId) {
        brandUserMapper.deleteByBrandId(brandId);
    }

    public List<BrandDO> getListByStateAndMy(Integer state, Integer my) {
        return brandMapper.selectListByStateAndMy(state,my);
    }

}
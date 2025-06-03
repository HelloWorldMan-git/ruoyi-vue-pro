package cn.iocoder.yudao.module.system.service.brand;

import java.util.*;

import cn.iocoder.yudao.module.system.dal.dataobject.brand.BrandUserDO;
import jakarta.validation.*;
import cn.iocoder.yudao.module.system.controller.admin.brand.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.brand.BrandDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 品牌 Service 接口
 *
 * @author 凸透镜
 */
public interface BrandService {

    /**
     * 创建品牌
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBrand(@Valid BrandSaveReqVO createReqVO);

    /**
     * 更新品牌
     *
     * @param updateReqVO 更新信息
     */
    void updateBrand(@Valid BrandSaveReqVO updateReqVO);

    /**
     * 删除品牌
     *
     * @param id 编号
     */
    void deleteBrand(Long id);

    /**
     * 获得品牌
     *
     * @param id 编号
     * @return 品牌
     */
    BrandRespVO getBrand(Long id);

    /**
     * 获得品牌分页
     *
     * @param pageReqVO 分页查询
     * @return 品牌分页
     */
    PageResult<BrandDO> getBrandPage(BrandPageReqVO pageReqVO);

    // ==================== 子表（品牌的参与者） ====================

    /**
     * 获得品牌的参与者分页
     *
     * @param pageReqVO 分页查询
     * @param brandId 品牌ID
     * @return 品牌的参与者分页
     */
    PageResult<BrandUserDO> getBrandUserPage(PageParam pageReqVO, Long brandId);

    /**
     * 创建品牌的参与者
     *
     * @param brandUser 创建信息
     * @return 编号
     */
    Long createBrandUser(@Valid BrandUserDO brandUser);

    /**
     * 更新品牌的参与者
     *
     * @param brandUser 更新信息
     */
    void updateBrandUser(@Valid BrandUserDO brandUser);

    /**
     * 删除品牌的参与者
     *
     * @param id 编号
     */
    void deleteBrandUser(Long id);

    /**
     * 获得品牌的参与者
     *
     * @param id 编号
     * @return 品牌的参与者
     */
    BrandUserDO getBrandUser(Long id);

    List<BrandDO> getListByStateAndMy(Integer state, Integer my);

}
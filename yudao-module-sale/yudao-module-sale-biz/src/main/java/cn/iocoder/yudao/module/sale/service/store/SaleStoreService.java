package cn.iocoder.yudao.module.sale.service.store;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.sale.controller.admin.store.vo.*;
import cn.iocoder.yudao.module.sale.dal.dataobject.store.SaleStoreDO;
import cn.iocoder.yudao.module.sale.dal.dataobject.item.SaleItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 店铺 Service 接口
 *
 * @author 凸透镜
 */
public interface SaleStoreService {

    /**
     * 创建店铺
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createStore(@Valid SaleStoreSaveReqVO createReqVO);

    /**
     * 更新店铺
     *
     * @param updateReqVO 更新信息
     */
    void updateStore(@Valid SaleStoreSaveReqVO updateReqVO);

    /**
     * 删除店铺
     *
     * @param id 编号
     */
    void deleteStore(Long id);

    /**
     * 获得店铺
     *
     * @param id 编号
     * @return 店铺
     */
    SaleStoreDO getStore(Long id);

    /**
     * 获得店铺分页
     *
     * @param pageReqVO 分页查询
     * @return 店铺分页
     */
    PageResult<SaleStoreDO> getStorePage(SaleStorePageReqVO pageReqVO);

    // ==================== 子表（商品） ====================

    /**
     * 获得商品分页
     *
     * @param pageReqVO 分页查询
     * @param storeId 店铺id
     * @return 商品分页
     */
    PageResult<SaleItemDO> getItemPage(PageParam pageReqVO, Long storeId);

    /**
     * 创建商品
     *
     * @param item 创建信息
     * @return 编号
     */
    Long createItem(@Valid SaleItemDO item);

    /**
     * 更新商品
     *
     * @param item 更新信息
     */
    void updateItem(@Valid SaleItemDO item);

    /**
     * 删除商品
     *
     * @param id 编号
     */
    void deleteItem(Long id);

	/**
	 * 获得商品
	 *
	 * @param id 编号
     * @return 商品
	 */
    SaleItemDO getItem(Long id);

}
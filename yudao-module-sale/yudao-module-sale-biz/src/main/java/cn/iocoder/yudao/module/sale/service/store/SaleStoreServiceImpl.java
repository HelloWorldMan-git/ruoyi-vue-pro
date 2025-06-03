package cn.iocoder.yudao.module.sale.service.store;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.sale.controller.admin.store.vo.*;
import cn.iocoder.yudao.module.sale.dal.dataobject.store.SaleStoreDO;
import cn.iocoder.yudao.module.sale.dal.dataobject.item.SaleItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.sale.dal.mysql.store.SaleStoreMapper;
import cn.iocoder.yudao.module.sale.dal.mysql.item.SaleItemMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.sale.enums.ErrorCodeConstants.*;

/**
 * 店铺 Service 实现类
 *
 * @author 凸透镜
 */
@Service
@Validated
public class SaleStoreServiceImpl implements SaleStoreService {

    @Resource
    private SaleStoreMapper storeMapper;
    @Resource
    private SaleItemMapper itemMapper;

    @Override
    public Long createStore(SaleStoreSaveReqVO createReqVO) {
        // 插入
        SaleStoreDO store = BeanUtils.toBean(createReqVO, SaleStoreDO.class);
        storeMapper.insert(store);
        // 返回
        return store.getId();
    }

    @Override
    public void updateStore(SaleStoreSaveReqVO updateReqVO) {
        // 校验存在
        validateStoreExists(updateReqVO.getId());
        // 更新
        SaleStoreDO updateObj = BeanUtils.toBean(updateReqVO, SaleStoreDO.class);
        storeMapper.updateById(updateObj);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteStore(Long id) {
        // 校验存在
        validateStoreExists(id);
        // 删除
        storeMapper.deleteById(id);

        // 删除子表
        deleteItemByStoreId(id);
    }

    private void validateStoreExists(Long id) {
        if (storeMapper.selectById(id) == null) {
            throw exception(STORE_NOT_EXISTS);
        }
    }

    @Override
    public SaleStoreDO getStore(Long id) {
        return storeMapper.selectById(id);
    }

    @Override
    public PageResult<SaleStoreDO> getStorePage(SaleStorePageReqVO pageReqVO) {
        return storeMapper.selectPage(pageReqVO);
    }

    // ==================== 子表（商品） ====================

    @Override
    public PageResult<SaleItemDO> getItemPage(PageParam pageReqVO, Long storeId) {
        return itemMapper.selectPage(pageReqVO, storeId);
    }

    @Override
    public Long createItem(SaleItemDO item) {
        itemMapper.insert(item);
        return item.getId();
    }

    @Override
    public void updateItem(SaleItemDO item) {
        // 校验存在
        validateItemExists(item.getId());
        // 更新
        item.setUpdater(null).setUpdateTime(null); // 解决更新情况下：updateTime 不更新
        itemMapper.updateById(item);
    }

    @Override
    public void deleteItem(Long id) {
        // 校验存在
        validateItemExists(id);
        // 删除
        itemMapper.deleteById(id);
    }

    @Override
    public SaleItemDO getItem(Long id) {
        return itemMapper.selectById(id);
    }

    private void validateItemExists(Long id) {
        if (itemMapper.selectById(id) == null) {
            throw exception(ITEM_NOT_EXISTS);
        }
    }

    private void deleteItemByStoreId(Long storeId) {
        itemMapper.deleteByStoreId(storeId);
    }

}
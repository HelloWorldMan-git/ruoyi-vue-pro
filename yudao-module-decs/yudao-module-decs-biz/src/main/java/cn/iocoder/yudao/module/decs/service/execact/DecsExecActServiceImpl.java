package cn.iocoder.yudao.module.decs.service.execact;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.decs.controller.admin.execact.vo.*;
import cn.iocoder.yudao.module.decs.dal.dataobject.execact.DecsExecActDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.decs.dal.mysql.execact.DecsExecActMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.decs.enums.ErrorCodeConstants.*;

/**
 * 执行动作 Service 实现类
 *
 * @author 凸透镜
 */
@Service
@Validated
public class DecsExecActServiceImpl implements DecsExecActService {

    @Resource
    private DecsExecActMapper execActMapper;

    @Override
    public Long createExecAct(DecsExecActSaveReqVO createReqVO) {
        // 插入
        DecsExecActDO execAct = BeanUtils.toBean(createReqVO, DecsExecActDO.class);
        execActMapper.insert(execAct);
        // 返回
        return execAct.getId();
    }

    @Override
    public void updateExecAct(DecsExecActSaveReqVO updateReqVO) {
        // 校验存在
        validateExecActExists(updateReqVO.getId());
        // 更新
        DecsExecActDO updateObj = BeanUtils.toBean(updateReqVO, DecsExecActDO.class);
        execActMapper.updateById(updateObj);
    }

    @Override
    public void deleteExecAct(Long id) {
        // 校验存在
        validateExecActExists(id);
        // 删除
        execActMapper.deleteById(id);
    }

    private void validateExecActExists(Long id) {
        if (execActMapper.selectById(id) == null) {
            throw exception(EXEC_ACT_NOT_EXISTS);
        }
    }

    @Override
    public DecsExecActDO getExecAct(Long id) {
        return execActMapper.selectById(id);
    }

    @Override
    public PageResult<DecsExecActDO> getExecActPage(DecsExecActPageReqVO pageReqVO) {
        return execActMapper.selectPage(pageReqVO);
    }

}
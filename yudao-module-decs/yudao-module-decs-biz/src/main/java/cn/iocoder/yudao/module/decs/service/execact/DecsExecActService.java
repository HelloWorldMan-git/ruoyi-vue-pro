package cn.iocoder.yudao.module.decs.service.execact;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.decs.controller.admin.execact.vo.*;
import cn.iocoder.yudao.module.decs.dal.dataobject.execact.DecsExecActDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 执行动作 Service 接口
 *
 * @author 凸透镜
 */
public interface DecsExecActService {

    /**
     * 创建执行动作
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExecAct(@Valid DecsExecActSaveReqVO createReqVO);

    /**
     * 更新执行动作
     *
     * @param updateReqVO 更新信息
     */
    void updateExecAct(@Valid DecsExecActSaveReqVO updateReqVO);

    /**
     * 删除执行动作
     *
     * @param id 编号
     */
    void deleteExecAct(Long id);

    /**
     * 获得执行动作
     *
     * @param id 编号
     * @return 执行动作
     */
    DecsExecActDO getExecAct(Long id);

    /**
     * 获得执行动作分页
     *
     * @param pageReqVO 分页查询
     * @return 执行动作分页
     */
    PageResult<DecsExecActDO> getExecActPage(DecsExecActPageReqVO pageReqVO);

}
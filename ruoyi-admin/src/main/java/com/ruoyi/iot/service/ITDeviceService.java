package com.ruoyi.iot.service;

import java.util.List;
import com.ruoyi.iot.domain.TDevice;

/**
 * 物联网终端Service接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface ITDeviceService 
{
    /**
     * 查询物联网终端
     * 
     * @param id 物联网终端主键
     * @return 物联网终端
     */
    public TDevice selectTDeviceById(Long id);

    /**
     * 查询物联网终端列表
     * 
     * @param tDevice 物联网终端
     * @return 物联网终端集合
     */
    public List<TDevice> selectTDeviceList(TDevice tDevice);

    /**
     * 新增物联网终端
     * 
     * @param tDevice 物联网终端
     * @return 结果
     */
    public int insertTDevice(TDevice tDevice);

    /**
     * 修改物联网终端
     * 
     * @param tDevice 物联网终端
     * @return 结果
     */
    public int updateTDevice(TDevice tDevice);

    /**
     * 批量删除物联网终端
     * 
     * @param ids 需要删除的物联网终端主键集合
     * @return 结果
     */
    public int deleteTDeviceByIds(String ids);

    /**
     * 删除物联网终端信息
     * 
     * @param id 物联网终端主键
     * @return 结果
     */
    public int deleteTDeviceById(Long id);
}

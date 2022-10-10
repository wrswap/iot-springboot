package com.ruoyi.iot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.iot.mapper.TDeviceMapper;
import com.ruoyi.iot.domain.TDevice;
import com.ruoyi.iot.service.ITDeviceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 物联网终端Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class TDeviceServiceImpl implements ITDeviceService 
{
    @Autowired
    private TDeviceMapper tDeviceMapper;

    /**
     * 查询物联网终端
     * 
     * @param id 物联网终端主键
     * @return 物联网终端
     */
    @Override
    public TDevice selectTDeviceById(Long id)
    {
        return tDeviceMapper.selectTDeviceById(id);
    }

    /**
     * 查询物联网终端列表
     * 
     * @param tDevice 物联网终端
     * @return 物联网终端
     */
    @Override
    public List<TDevice> selectTDeviceList(TDevice tDevice)
    {
        return tDeviceMapper.selectTDeviceList(tDevice);
    }

    /**
     * 新增物联网终端
     * 
     * @param tDevice 物联网终端
     * @return 结果
     */
    @Override
    public int insertTDevice(TDevice tDevice)
    {
        return tDeviceMapper.insertTDevice(tDevice);
    }

    /**
     * 修改物联网终端
     * 
     * @param tDevice 物联网终端
     * @return 结果
     */
    @Override
    public int updateTDevice(TDevice tDevice)
    {
        return tDeviceMapper.updateTDevice(tDevice);
    }

    /**
     * 批量删除物联网终端
     * 
     * @param ids 需要删除的物联网终端主键
     * @return 结果
     */
    @Override
    public int deleteTDeviceByIds(String ids)
    {
        return tDeviceMapper.deleteTDeviceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物联网终端信息
     * 
     * @param id 物联网终端主键
     * @return 结果
     */
    @Override
    public int deleteTDeviceById(Long id)
    {
        return tDeviceMapper.deleteTDeviceById(id);
    }
}

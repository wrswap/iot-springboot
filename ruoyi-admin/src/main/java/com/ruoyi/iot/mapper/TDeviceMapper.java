package com.ruoyi.iot.mapper;

import java.util.List;
import com.ruoyi.iot.domain.TDevice;

/**
 * 物联网终端Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface TDeviceMapper 
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
     * 删除物联网终端
     * 
     * @param id 物联网终端主键
     * @return 结果
     */
    public int deleteTDeviceById(Long id);

    /**
     * 批量删除物联网终端
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTDeviceByIds(String[] ids);
}

package com.ruoyi.iot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.iot.mapper.THistoryMapper;
import com.ruoyi.iot.domain.THistory;
import com.ruoyi.iot.service.ITHistoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 历史Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class THistoryServiceImpl implements ITHistoryService 
{
    @Autowired
    private THistoryMapper tHistoryMapper;

    /**
     * 查询历史
     * 
     * @param id 历史主键
     * @return 历史
     */
    @Override
    public THistory selectTHistoryById(Long id)
    {
        return tHistoryMapper.selectTHistoryById(id);
    }

    /**
     * 查询历史列表
     * 
     * @param tHistory 历史
     * @return 历史
     */
    @Override
    public List<THistory> selectTHistoryList(THistory tHistory)
    {
        return tHistoryMapper.selectTHistoryList(tHistory);
    }

    /**
     * 新增历史
     * 
     * @param tHistory 历史
     * @return 结果
     */
    @Override
    public int insertTHistory(THistory tHistory)
    {
        return tHistoryMapper.insertTHistory(tHistory);
    }

    /**
     * 修改历史
     * 
     * @param tHistory 历史
     * @return 结果
     */
    @Override
    public int updateTHistory(THistory tHistory)
    {
        return tHistoryMapper.updateTHistory(tHistory);
    }

    /**
     * 批量删除历史
     * 
     * @param ids 需要删除的历史主键
     * @return 结果
     */
    @Override
    public int deleteTHistoryByIds(String ids)
    {
        return tHistoryMapper.deleteTHistoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除历史信息
     * 
     * @param id 历史主键
     * @return 结果
     */
    @Override
    public int deleteTHistoryById(Long id)
    {
        return tHistoryMapper.deleteTHistoryById(id);
    }
}

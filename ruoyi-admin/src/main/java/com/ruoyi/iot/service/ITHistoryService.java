package com.ruoyi.iot.service;

import java.util.List;
import com.ruoyi.iot.domain.THistory;

/**
 * 历史Service接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface ITHistoryService 
{
    /**
     * 查询历史
     * 
     * @param id 历史主键
     * @return 历史
     */
    public THistory selectTHistoryById(Long id);

    /**
     * 查询历史列表
     * 
     * @param tHistory 历史
     * @return 历史集合
     */
    public List<THistory> selectTHistoryList(THistory tHistory);

    /**
     * 新增历史
     * 
     * @param tHistory 历史
     * @return 结果
     */
    public int insertTHistory(THistory tHistory);

    /**
     * 修改历史
     * 
     * @param tHistory 历史
     * @return 结果
     */
    public int updateTHistory(THistory tHistory);

    /**
     * 批量删除历史
     * 
     * @param ids 需要删除的历史主键集合
     * @return 结果
     */
    public int deleteTHistoryByIds(String ids);

    /**
     * 删除历史信息
     * 
     * @param id 历史主键
     * @return 结果
     */
    public int deleteTHistoryById(Long id);
}

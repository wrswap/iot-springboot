package com.ruoyi.iot.mapper;

import java.util.List;
import com.ruoyi.iot.domain.THistory;

/**
 * 历史Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface THistoryMapper 
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
     * 删除历史
     * 
     * @param id 历史主键
     * @return 结果
     */
    public int deleteTHistoryById(Long id);

    /**
     * 批量删除历史
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTHistoryByIds(String[] ids);
}

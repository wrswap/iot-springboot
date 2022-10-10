package com.ruoyi.iot.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.iot.domain.THistory;
import com.ruoyi.iot.service.ITHistoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 历史Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/iot/history")
public class THistoryController extends BaseController
{
    private String prefix = "iot/history";

    @Autowired
    private ITHistoryService tHistoryService;

    @RequiresPermissions("iot:history:view")
    @GetMapping()
    public String history()
    {
        return prefix + "/history";
    }

    /**
     * 查询历史列表
     */
    @RequiresPermissions("iot:history:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(THistory tHistory)
    {
        startPage();
        List<THistory> list = tHistoryService.selectTHistoryList(tHistory);
        return getDataTable(list);
    }

    /**
     * 导出历史列表
     */
    @RequiresPermissions("iot:history:export")
    @Log(title = "历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(THistory tHistory)
    {
        List<THistory> list = tHistoryService.selectTHistoryList(tHistory);
        ExcelUtil<THistory> util = new ExcelUtil<THistory>(THistory.class);
        return util.exportExcel(list, "历史数据");
    }

    /**
     * 新增历史
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }


    /**
     * 新增保存历史
     */
    @RequiresPermissions("iot:history:add")
    @Log(title = "历史", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(THistory tHistory)
    {
        return toAjax(tHistoryService.insertTHistory(tHistory));
    }

    /**
     * 修改历史
     */
    @RequiresPermissions("iot:history:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        THistory tHistory = tHistoryService.selectTHistoryById(id);
        mmap.put("tHistory", tHistory);
        return prefix + "/edit";
    }

    /**
     * 修改保存历史
     */
    @RequiresPermissions("iot:history:edit")
    @Log(title = "历史", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(THistory tHistory)
    {
        return toAjax(tHistoryService.updateTHistory(tHistory));
    }

    /**
     * 删除历史
     */
    @RequiresPermissions("iot:history:remove")
    @Log(title = "历史", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tHistoryService.deleteTHistoryByIds(ids));
    }
}

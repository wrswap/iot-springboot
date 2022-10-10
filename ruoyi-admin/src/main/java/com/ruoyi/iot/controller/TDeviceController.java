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
import com.ruoyi.iot.domain.TDevice;
import com.ruoyi.iot.service.ITDeviceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物联网终端Controller
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Controller
@RequestMapping("/iot/device")
public class TDeviceController extends BaseController
{
    private String prefix = "iot/device";

    @Autowired
    private ITDeviceService tDeviceService;

    @RequiresPermissions("iot:device:view")
    @GetMapping()
    public String device()
    {
        return prefix + "/device";
    }

    /**
     * 查询物联网终端列表
     */
    @RequiresPermissions("iot:device:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TDevice tDevice)
    {
        startPage();
        List<TDevice> list = tDeviceService.selectTDeviceList(tDevice);
        return getDataTable(list);
    }

    /**
     * 导出物联网终端列表
     */
    @RequiresPermissions("iot:device:export")
    @Log(title = "物联网终端", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TDevice tDevice)
    {
        List<TDevice> list = tDeviceService.selectTDeviceList(tDevice);
        ExcelUtil<TDevice> util = new ExcelUtil<TDevice>(TDevice.class);
        return util.exportExcel(list, "物联网终端数据");
    }

    /**
     * 新增物联网终端
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存物联网终端
     */
    @RequiresPermissions("iot:device:add")
    @Log(title = "物联网终端", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TDevice tDevice)
    {
        return toAjax(tDeviceService.insertTDevice(tDevice));
    }

    /**
     * 修改物联网终端
     */
    @RequiresPermissions("iot:device:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TDevice tDevice = tDeviceService.selectTDeviceById(id);
        mmap.put("tDevice", tDevice);
        return prefix + "/edit";
    }

    /**
     * 修改保存物联网终端
     */
    @RequiresPermissions("iot:device:edit")
    @Log(title = "物联网终端", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TDevice tDevice)
    {
        return toAjax(tDeviceService.updateTDevice(tDevice));
    }

    /**
     * 删除物联网终端
     */
    @RequiresPermissions("iot:device:remove")
    @Log(title = "物联网终端", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tDeviceService.deleteTDeviceByIds(ids));
    }
}

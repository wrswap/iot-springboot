package com.ruoyi.iot.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物联网终端对象 t_device
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class TDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 单元识别码 */
    @Excel(name = "单元识别码")
    private Long station;

    /** 温度 */
    @Excel(name = "温度")
    private BigDecimal temperature;

    /** 水位 */
    @Excel(name = "水位")
    private BigDecimal waterlevel;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uptime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setStation(Long station) 
    {
        this.station = station;
    }

    public Long getStation() 
    {
        return station;
    }
    public void setTemperature(BigDecimal temperature) 
    {
        this.temperature = temperature;
    }

    public BigDecimal getTemperature() 
    {
        return temperature;
    }
    public void setWaterlevel(BigDecimal waterlevel) 
    {
        this.waterlevel = waterlevel;
    }

    public BigDecimal getWaterlevel() 
    {
        return waterlevel;
    }
    public void setUptime(Date uptime) 
    {
        this.uptime = uptime;
    }

    public Date getUptime() 
    {
        return uptime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("station", getStation())
            .append("temperature", getTemperature())
            .append("waterlevel", getWaterlevel())
            .append("uptime", getUptime())
            .toString();
    }
}

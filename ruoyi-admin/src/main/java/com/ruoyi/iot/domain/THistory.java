package com.ruoyi.iot.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 历史对象 t_history
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class THistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 设备序号 */
    @Excel(name = "设备序号")
    private Long deviceid;

    /** 温度 */
    @Excel(name = "温度")
    private BigDecimal temperature;

    /** 水位 */
    @Excel(name = "水位")
    private BigDecimal waterlevel;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uptime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceid(Long deviceid) 
    {
        this.deviceid = deviceid;
    }

    public Long getDeviceid() 
    {
        return deviceid;
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
            .append("deviceid", getDeviceid())
            .append("temperature", getTemperature())
            .append("waterlevel", getWaterlevel())
            .append("uptime", getUptime())
            .toString();
    }
}

package cn.lanca.v1.entity;

import java.io.Serializable;

/**
 * (ShArea)实体类
 *
 * @author makejava
 * @since 2022-03-28 10:53:36
 */
public class ShArea implements Serializable {
    private static final long serialVersionUID = 858641592607515231L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 父id
     */
    private Integer pid;
    /**
     * 简称
     */
    private String shortName;
    /**
     * 名称
     */
    private String name;
    /**
     * 全称
     */
    private String mergerName;
    /**
     * 层级 0 1 2 省市区县
     */
    private Integer level;
    /**
     * 拼音
     */
    private String pinyin;
    /**
     * 长途区号
     */
    private String code;
    /**
     * 邮编
     */
    private String zipCode;
    /**
     * 首字母
     */
    private String first;
    /**
     * 经度
     */
    private String lng;
    /**
     * 纬度
     */
    private String lat;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

}


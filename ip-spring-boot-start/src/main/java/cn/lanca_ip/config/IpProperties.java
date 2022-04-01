package cn.lanca_ip.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/4/1 10:31  <br>
 */

@ConfigurationProperties(prefix = "tools.ip")
public class IpProperties {

    /**
     * 喊你读书你要去喂猪
     */
    private Long id;
    /**
     * string name 名称yy
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IpProperties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

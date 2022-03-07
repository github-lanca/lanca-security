package cn.lanca.forest;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.GetRequest;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/7 10:08  <br>
 */
@Address(host = "172.27.16.11", port = "43900")
public interface GetToken {

    /**
     * GET请求
     * 172.27.16.11:43900/get-youzan-token?grantId=102631073
     *
     * @param grantId 企业id
     * @return token
     */
    @GetRequest("/get-youzan-token?grantId={0}")
    String getYouzanToken(String grantId);
}

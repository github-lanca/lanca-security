package cn.lanca.esaypoi.controller;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.DrugVo;
import com.alibaba.excel.EasyExcel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/22 17:26  <br>
 */
@RestController
public class ExcelController {

    //批量新增，文件解析
    @RequestMapping("/fileUpload")
    public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        ExcelListener<DrugVo> userListener = new ExcelListener<DrugVo>();
        EasyExcel.read(new FileInputStream("/Users/meihongliang/Downloads/OTC药品系列.xls"), DrugVo.class, userListener).sheet().doRead();
        List<DrugVo> objs = userListener.getObjs();
        for (DrugVo obj : objs) {
            System.out.println(obj);
        }
    }
}

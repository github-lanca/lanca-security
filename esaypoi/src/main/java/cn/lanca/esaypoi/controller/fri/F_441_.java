package cn.lanca.esaypoi.controller.fri;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v0.CommonVo;
import cn.lanca.esaypoi.util.ExcelElListener;
import com.alibaba.excel.EasyExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * project name:<font size="1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size="1"><b>DictTemplate</b></font><br>
 * description:<font size="1"><b>平台字典数据操作实现类</b></font><br>
 * company name:<font size="1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: ">mei.hongliang<br>
 * @version 1.0.0<br>
 * @since 2022/3/25 15:05  <br>
 */
public class F_441_ {
    public static void main(String[] args) throws FileNotFoundException {

//        List<CommonVo> commonVos = get441();
//        System.out.println(commonVos.size());
//        CommonVo commonVo = commonVos.get(0);
//        System.out.println(commonVo);
//        String s = commonVo.getA10() + "_" + commonVo.getA4() + "_";
//        System.out.println(s);


        FileInputStream fileInputStream = new FileInputStream("/Users/meihongliang/Downloads/A_xiaowan/fri/3098完全匹配剩余441.xlsx");
        ExcelElListener userListener = new ExcelElListener();
        EasyExcel.read(fileInputStream, userListener).sheet().doRead();
//        System.out.println(userListener.getList().get(0));
        System.out.println(userListener.getHeadTitleMap());
        System.out.println(userListener.getOriginallist());
        //System.out.println(userListener.getList().toString());


    }

    private static List<CommonVo> get441() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/A_xiaowan/fri/3098完全匹配剩余441.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }
}

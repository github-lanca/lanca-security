package cn.lanca.esaypoi.controller.v2;

import cn.lanca.esaypoi.util.ChineseToFirstLetterUtil;
import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.util.ReplaceStriUtils;
import com.alibaba.excel.EasyExcel;

import java.io.File;
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
 * @since 2022/3/29 11:39  <br>
 */
public class GetPinyin {

    /**
     * 2022-03-29 处理1023条数据
     *
     * @param args args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        String baseDir = "/Users/meihongliang/Downloads/0406/";

        List<CommonVo_pinyin> pinyins = get1023();
        System.out.println("Total:" + pinyins.size());
        System.out.println(pinyins.get(0));
        for (int i = 0; i < pinyins.size(); i++) {
            CommonVo_pinyin pinyin = pinyins.get(i);
            // a2=药品标准名首拼
            String a1 = pinyin.getA1();
            String s = ChineseToFirstLetterUtil.ChineseToFirstLetter(a1);
            pinyin.setA2(s);

            // a7=规格
            String a7 = pinyin.getA7();
            String s12 = ReplaceStriUtils.replaceString(a7);
            pinyin.setA12(s12);
            // System.out.println(pinyin);
        }

        File file2 = new File("/Users/meihongliang/Downloads/标库-福源店院外652_用量单位_首拼.xlsx");
         EasyExcel.write(file2, CommonVo_pinyin.class).sheet(pinyins.size() + "").doWrite(pinyins);
    }

    /**
     * title: <font size="1"><b> </b></font><br>
     * description:<font size="1"><b> </b></font><br>
     *
     * @param null
     * @author <a href="">meihongliang</a><br>
     * @since 2022/3/30 10:20 <br>
     * @return  <br>
     */

    /**
     * @return
     */
    private static List<CommonVo_pinyin> get1023() throws FileNotFoundException {
        ExcelListener<CommonVo_pinyin> userListener55555 = new ExcelListener<>();
        String fileName96 = "/Users/meihongliang/Downloads/标库-福源店院外652.xlsx";
        EasyExcel.read(new FileInputStream(fileName96), CommonVo_pinyin.class, userListener55555).sheet().doRead();
        return userListener55555.getObjs();
    }


}

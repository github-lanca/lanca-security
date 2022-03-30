package cn.lanca.esaypoi.controller.fri;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v0.AandBVo;
import cn.lanca.esaypoi.vo.v0.CommonVo;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
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
public class C {
    public static void main(String[] args) throws FileNotFoundException {
        List<CommonVo> commonVos = get84124();//84124
        List<AandBVo> aandBVos = get1327();//1327
        System.out.println(commonVos.get(0));
        System.out.println(aandBVos.get(0));
        System.out.println("开始:" + aandBVos.size());

        Iterator<AandBVo> iterator = aandBVos.iterator();
        HashSet<String> keyList = new HashSet<>();
        while (iterator.hasNext()) {
            AandBVo next = iterator.next();
            Iterator<CommonVo> commonVoIterator = commonVos.iterator();
            while (commonVoIterator.hasNext()) {
                CommonVo commonVo = commonVoIterator.next();
                if (next.getA15().equals(commonVo.getA11())) {
//                    System.out.println(next.getA15());
                    keyList.add(next.getA15());
                    // iterator.remove();
                }
            }
        }
        System.out.println("结束:" + aandBVos.size());
        System.out.println("keyList:" + keyList.size());

        Iterator<AandBVo> aandBVoIterator = aandBVos.iterator();
        while (aandBVoIterator.hasNext()) {
            AandBVo next = aandBVoIterator.next();
            keyList.forEach(e -> {
                if (next.getA15().equals(e)) {
                    aandBVoIterator.remove();
                }
            });
        }
        System.out.println("end:" + aandBVos.size());

        // #3生成图片文件，excel文件
        File file2 = new File("/Users/meihongliang/Downloads/A_xiaowan/fri/1327未匹配上的数据.xlsx");
        EasyExcel.write(file2, AandBVo.class).sheet("94").doWrite(aandBVos);

    }

    private static List<CommonVo> get84124() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/A_xiaowan/fri/A_全部数据_84124.xlsx";
        EasyExcel.read(new FileInputStream(a), CommonVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }


    private static List<AandBVo> get1327() throws FileNotFoundException {
        ExcelListener<AandBVo> userListener = new ExcelListener<>();
        String a = "/Users/meihongliang/Downloads/A_xiaowan/fri/建设路药品表1327.xlsx";
        EasyExcel.read(new FileInputStream(a), AandBVo.class, userListener).sheet().doRead();
        return userListener.getObjs();
    }
}

package cn.lanca.esaypoi.controller.v2;

import cn.lanca.esaypoi.util.ExcelListener;
import com.alibaba.excel.EasyExcel;
import org.springframework.util.StringUtils;

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
public class GetImage {

    /**
     * 2022-03-29 处理1023条数据
     *
     * @param args args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        String baseDir = "/Users/meihongliang/Downloads/0406/";

        List<CommonVo_0406> drugVos = get1023();
        System.out.println("Total:" + drugVos.size());
        System.out.println(drugVos.get(0));
        int totalNumber = 0;
        for (int i = 0; i < drugVos.size(); i++) {
            CommonVo_0406 drugVo = drugVos.get(i);
            String oriImages = drugVo.getA6();
            if (StringUtils.hasLength(oriImages)) {
                String[] split = oriImages.split(",");
                System.out.println("第" + (i + 1) + "条数据,图片数量:" + split.length);
                totalNumber += split.length;
                StringBuilder stringBuilder = new StringBuilder();
                for (int i1 = 0; i1 < split.length; i1++) {
                    //
                    String singleUrl = split[i1];
                    //
                    String picName = drugVo.getA16() + "_" + drugVo.getA4() + "_" + (i1 + 1);
                    try {
//                        ImageUtils.downloadPicture(singleUrl, baseDir + picName + ".jpg");
                        stringBuilder.append(picName).append(";");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
                }
                if (StringUtils.hasLength(stringBuilder) && stringBuilder.toString().contains(";")) {
                    String imagesExcel = stringBuilder.substring(0, stringBuilder.lastIndexOf(";"));
                    System.out.println(imagesExcel);
                    drugVo.setA28(imagesExcel);
                }
            }
        }
        // 180 181 192 193 275
        System.out.println(drugVos.get(0));
        System.out.println("图片总数L: " + totalNumber);
        //List<CommonVo_0406> sortResult = drugVos.stream().sorted(Comparator.comparing(CommonVo_0406::getA10)).collect(Collectors.toList());
        File file2 = new File("/Users/meihongliang/Downloads/福源店院外找图片字段307已完成_提取图片.xlsx");
         EasyExcel.write(file2, CommonVo_0406.class).sheet(drugVos.size() + "").doWrite(drugVos);
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
    private static List<CommonVo_0406> get1023() throws FileNotFoundException {
        ExcelListener<CommonVo_0406> userListener55555 = new ExcelListener<>();
        String fileName96 = "/Users/meihongliang/Downloads/福源店院外找图片字段307已完成.xls";
        EasyExcel.read(new FileInputStream(fileName96), CommonVo_0406.class, userListener55555).sheet().doRead();
        return userListener55555.getObjs();
    }


}

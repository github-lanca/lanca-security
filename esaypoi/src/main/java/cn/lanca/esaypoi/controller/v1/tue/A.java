package cn.lanca.esaypoi.controller.v1.tue;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.CommonVo;
import com.alibaba.excel.EasyExcel;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
public class A {
    /**
     * 2022-03-29 处理1023条数据
     *
     * @param args args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        String baseDir = "/Users/meihongliang/Downloads/0329/";

        List<CommonVo> drugVos = get1023();
        System.out.println("Total:" + drugVos.size());
        // a18是图片url地址 a10是批准文号 a4是药品通用名
//        System.out.println(drugVos.get(0));

        /**
         * */
        List<Integer> integerList = new ArrayList<>();
        integerList.add(216);
        integerList.add(209);
        integerList.add(346);
        integerList.add(399);
        integerList.add(400);
        integerList.add(535);
        integerList.add(731);
        integerList.add(732);
        integerList.add(757);
        integerList.add(810);
        integerList.add(813);
        integerList.add(857);
        integerList.add(863);
        integerList.add(959);
        for (int i = 0; i < drugVos.size(); i++) {
            // 216 209 346 399 400 535 731 732 757 810 813 857 863 959
            // 346 国药准字H20110006
//            if (i < 180) {
//            if (!integerList.contains(i)) {
//                // 跳出当前循环
//                continue;
//            }
            CommonVo drugVo = drugVos.get(i);
            String oriImages = drugVo.getA18();
            if (StringUtils.hasLength(oriImages)) {
                String[] split = oriImages.split(",");
                System.out.println("第" + (i + 1) + "条数据,图片数量:" + split.length);
                StringBuilder stringBuilder = new StringBuilder();
                for (int i1 = 0; i1 < split.length; i1++) {
                    //
                    String singleUrl = split[i1];
                    String picName = drugVo.getA10() + "_" + drugVo.getA4() + "_" + (i1 + 1);
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
                    //System.out.println(imagesExcel);
                    drugVo.setKey2(imagesExcel);
                }
            }
        }
//        System.out.println(drugVos.get(0));

        // ----
        // 441
        List<CommonVo> sortResult = drugVos.stream().sorted(Comparator.comparing(CommonVo::getA10)).collect(Collectors.toList());
        File file2 = new File("/Users/meihongliang/Downloads/建设路-1327-1023提取图片_return_2.xlsx");
        EasyExcel.write(file2, CommonVo.class).sheet(sortResult.size() + "").doWrite(sortResult);
    }

    private static List<CommonVo> get1023() throws FileNotFoundException {
        ExcelListener<CommonVo> userListener55555 = new ExcelListener<>();
        String fileName96 = "/Users/meihongliang/Downloads/建设路-1327-1023提取图片.xls";
        EasyExcel.read(new FileInputStream(fileName96), CommonVo.class, userListener55555).sheet().doRead();
        return userListener55555.getObjs();
    }
}

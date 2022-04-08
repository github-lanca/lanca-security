package cn.lanca.esaypoi.controller.v3;

import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.util.ImageUtils;
import com.alibaba.excel.EasyExcel;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * project name:<font size = "1"><b>小芄健康数据运营平台</b></font><br>
 * file name:<font size = "1"><b>TODO</b></font><br>
 * description:<font size = "1"><b>TODO</b></font><br>
 * company name:<font size = "1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: meihongliang@xiaowanjiankang.com" rel="nofollow">meihongliang<br>
 * @version 1.0.0<br>
 * @since [1] [2022/4/7 21:30] [meihongliang] [新建] <br>
 */
public class Test_Image {
    public static void main(String[] args) throws FileNotFoundException {

        String baseDir = "/Users/meihongliang/Downloads/A_xiaowan/0408/";
        List<CommonOther> all = getAll();
        System.out.println(all.size());
        System.out.println(all.get(0));
        for (int m = 0; m < all.size(); m++) {
            CommonOther commonOther = all.get(m);
            String imageUrls = commonOther.getA19();
            if (StringUtils.hasText(imageUrls)) {
                String[] split = imageUrls.split(",");
                // 国药准字Z20093252_乳宁片(纤如意)_1
                String preString = commonOther.getA8() + "_" + commonOther.getA3();
                StringBuffer stringBuffer = new StringBuffer();
                System.out.println("第" + m + "条数据,图片数量:" + split.length);
                for (int i = 0; i < split.length; i++) {
                    String url = split[i];
                    System.out.println(url);
                    String imageName = preString + "_" + (i + 1);
                    try {
                        ImageUtils.downloadPicture(url, baseDir + imageName + ".jpg");
                        // 成功了才加
                        stringBuffer.append(imageName).append(";");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                String name = stringBuffer.substring(0, stringBuffer.lastIndexOf(";"));
//                System.out.println(imageName);
                commonOther.setA20(name);
            }
        }

        File file1 = new File("/Users/meihongliang/Downloads/新增上线品种（福源店）的副本_完全匹配_带图片名称.xlsx");
         EasyExcel.write(file1, CommonOther.class).sheet(all.size() + "").doWrite(all);
    }

    private static List<CommonOther> getAll() throws FileNotFoundException {
        ExcelListener<CommonOther> userListener55555 = new ExcelListener<>();
        String fileName96 = "/Users/meihongliang/Downloads/新增上线品种（福源店）的副本_完全匹配.xlsx";
        EasyExcel.read(new FileInputStream(fileName96), CommonOther.class, userListener55555).sheet().doRead();
        return userListener55555.getObjs();

        //网店商品分组	商品品牌	药品商品名:	商品名称	药品通用名	药品规格	产品剂型	疾病:	商品卖点	使用剂量:	批准文号	有效期	商品类目值	生产企业	药品类别	用法	适用人群:	条形码	产品图片
        //网店商品分组	商品品牌	药品商品名:	商品名称	药品通用名	药品规格	产品剂型	疾病:	商品卖点	使用剂量	    批准文号	有效期	"商品类目值   生产企业	药品类别	用法	适用人群:	条形码	产品图片	对应商品编码
    }
}

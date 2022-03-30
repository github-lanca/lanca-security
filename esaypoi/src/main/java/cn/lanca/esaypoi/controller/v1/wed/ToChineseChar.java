package cn.lanca.esaypoi.controller.v1.wed;

import cn.lanca.esaypoi.util.ChineseToFirstLetterUtil;
import cn.lanca.esaypoi.util.ExcelListener;
import cn.lanca.esaypoi.vo.v1.wed.V1CommonVO;
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
 * @since 2022/3/30 10:48  <br>
 */
public class ToChineseChar {
    /**
     * 商品名首拼
     *
     * @param args args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        List<V1CommonVO> commonVos = get1327();
        commonVos.forEach(e -> {
            if (e != null) {
                e.setA4(getChineseStr(e.getA6(), e.getA3()));
                e.setA8(getNewA7(e.getA7()));
            }
        });
        System.out.println(commonVos.size());
        V1CommonVO v1CommonVO = commonVos.get(0);
        System.out.println(v1CommonVO.getA6() + "|" + ChineseToFirstLetterUtil.ChineseToFirstLetter(v1CommonVO.getA6()));
        System.out.println("A7_" + v1CommonVO.getA7());
        System.out.println(commonVos.get(0));

//         List<V1CommonVO> sortResult = commonVos.stream().sorted(Comparator.comparing(V1CommonVO::getA13)).collect(Collectors.toList());
        File file2 = new File("/Users/meihongliang/Downloads/人工筛选-建设路1327提供字段_return.xlsx");
        EasyExcel.write(file2, V1CommonVO.class).sheet(commonVos.size() + "").doWrite(commonVos);


    }

    private static String getChineseStr(String a6, String a3) {
        String result = "";
        if (StringUtils.hasLength(a6)) {
            result = ChineseToFirstLetterUtil.ChineseToFirstLetter(a6);
            if (StringUtils.hasLength(result)) {
                return result;
            }
        }
        if (StringUtils.hasLength(a3)) {
            result = ChineseToFirstLetterUtil.ChineseToFirstLetter(a3);
        }

        return result;
    }

    private static String getNewA7(String a17) {
        String result = a17;
        if (result.contains("ml")) {
            result = "ml";
        }
        if (result.contains("μg")) {
            result = "μg";
        }
        if (result.contains("ug")) {
            result = "μg";
        }
        if (result.contains("mg")) {
            result = "mg";
        }//μg
        if (result.contains("g")) {
            result = "g";
        }
        if (result.contains("片")) {
            result = "片";
        }//粒
        if (result.contains("粒")) {
            result = "粒";
        }//丸
        if (result.contains("丸")) {
            result = "丸";
        }//贴
        if (result.contains("贴")) {
            result = "贴";
        }//枚
        if (result.contains("枚")) {
            result = "枚";
        }//毫升
        if (result.contains("毫升")) {
            result = "毫升";
        }//袋
        if (result.contains("袋")) {
            result = "袋";
        }//克
        if (result.contains("克")) {
            result = "克";
        }//帖
        if (result.contains("帖")) {
            result = "帖";
        }
        return result;
    }

    private static List<V1CommonVO> get1327() throws FileNotFoundException {
        ExcelListener<V1CommonVO> userListener55555 = new ExcelListener<>();
        String fileName96 = "/Users/meihongliang/Downloads/人工筛选-建设路1327提供字段.xlsx";
        EasyExcel.read(new FileInputStream(fileName96), V1CommonVO.class, userListener55555).sheet().doRead();
        return userListener55555.getObjs();
    }
}

package cn.lanca.esaypoi.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * project name:<font size = "1"><b>1</b></font><br>
 * file name:<font size = "1"><b>1</b></font><br>
 * description:<font size = "1"><b>1</b></font><br>
 * company name:<font size = "1"><b>小芄医药科技（成都）有限公司-研发中心</b></font><br>
 *
 * @author <a href="mail to: wujie@xiaowanjiankang.com">wujie<br>
 * @version 1.0.0<br>
 * @update [1] [2022/3/15 11:29] [wujie] [新建] <br>
 */
public class ExcelElListener extends AnalysisEventListener<Map<Integer, String>> {
    //Excel数据
    private List<Map<Integer, Map<Integer, String>>> list;
    private List<Map<Integer, String>> originallist = new LinkedList<>();
    private List<List<String>> originalData = new LinkedList<>();
    //Excel列名
    private Map<Integer, String> headTitleMap = new LinkedHashMap<>();

    public ExcelElListener() {
        list = new ArrayList<>();
    }

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
//        System.out.println("解析到一条数据：" + JSON.toJSONString(data));
        Map<Integer, Map<Integer, String>> map = new LinkedHashMap<>();
        map.put(context.readRowHolder().getRowIndex(), data);
        list.add(map);
        originallist.add(data);
        originalData.add(new ArrayList<>(data.values()));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("所有数据解析完成");
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        headTitleMap = headMap;
    }

    public List<Map<Integer, Map<Integer, String>>> getList() {
        return list;
    }

    public void setList(List<Map<Integer, Map<Integer, String>>> list) {
        this.list = list;
    }

    public Map<Integer, String> getHeadTitleMap() {
        return headTitleMap;
    }

    public void setHeadTitleMap(Map<Integer, String> headTitleMap) {
        this.headTitleMap = headTitleMap;
    }

    public List<Map<Integer, String>> getOriginallist() {
        return originallist;
    }

    public void setOriginallist(List<Map<Integer, String>> originallist) {
        this.originallist = originallist;
    }

    public List<List<String>> getOriginalData() {
        return originalData;
    }

    public void setOriginalData(List<List<String>> originalData) {
        this.originalData = originalData;
    }
}

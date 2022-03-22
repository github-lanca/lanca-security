package cn.lanca.esaypoi.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: ExcelListener <br>
 * @since: 2022/1/8 1:43 下午 <br>
 * @author: wujie <br>
 * @version: <br>
 */
@Slf4j
public class ExcelListener<T> extends AnalysisEventListener<T> {

    @Getter
    private List<T> objs = new LinkedList<>();

    public void clearList() {
        objs.clear();
    }

    /**
     * 每一条数据解析都会调用
     */
    @Override
    public void invoke(T obj, AnalysisContext context) {
        //System.out.println(new Gson().toJson(obj));
        objs.add(obj);
    }

    /**
     * 所有数据解析完成都会调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
//        objs.forEach(System.out::println);
    }
}

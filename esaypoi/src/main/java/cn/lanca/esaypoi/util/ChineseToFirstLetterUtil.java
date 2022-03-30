package cn.lanca.esaypoi.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @description: ChineseToFirstLetterUtil <br>
 * @since: 2022/1/8 1:36 下午 <br>
 * @author: wujie <br>
 * @version: <br>
 */
public class ChineseToFirstLetterUtil {

    /**
     * title:<font size = "1"><b></b></font><br>
     * description:<font size = "1"><b>简拼音大写</b></font><br>
     * @param c<br>
     * @return <br>
     * @author <a href="mail to: wujie@xiaowanjiankang.com" rel="nofollow">wujie<br>
     * @update [1] [2022/3/2 09:34] [wujie] [新建] <br>
     */
    public static String ChineseToFirstLetter(String c) {

        String string = "";
        char b;
        int a = c.length();
        for (int k = 0; k < a; k++) {
            b = c.charAt(k);
            String d = String.valueOf(b);
            String str = converterToFirstSpell(d);
            String s = str.toUpperCase();
            String g = s;
            char h;
            int j = g.length();
            for (int y = 0; y <= 0; y++) {
                h = g.charAt(0);
                string += h;
            }
        }
        return string;
    }

    /**
     * title:<font size = "1"><b></b></font><br>
     * description:<font size = "1"><b>全部拼音</b></font><br>
     * @param chines<br>
     * @return <br>
     * @author <a href="mail to: wujie@xiaowanjiankang.com" rel="nofollow">wujie<br>
     * @update [1] [2022/3/2 09:34] [wujie] [新建] <br>
     */
    public static String converterToFirstSpell(String chines) {

        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            String s = String.valueOf(nameChar[i]);
            if (s.matches("[\\u4e00-\\u9fa5]")) {
                try {
                    String[] mPinyinArray = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
                    pinyinName += mPinyinArray[0];
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }

    public static void main(String[] args) {
        System.err.println(ChineseToFirstLetter("犯我中华者虽远必诛"));
        System.err.println(converterToFirstSpell("犯我中华者虽远必诛"));
    }
}

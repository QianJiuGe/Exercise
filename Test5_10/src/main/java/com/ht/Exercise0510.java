package com.ht;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author HuangTao
 * @Description //TODO 正则表达式
 * @Date 9:53 2021/5/10
 * @Param 
 * @return 
 **/
public class Exercise0510 {

    /**Pattern可以将正则表达式编译为一个模式，其他的Matcher可以共用**/
    private Pattern p = Pattern.compile("a*b");

    public void main(String[] args) {

        /**
         * 通过调用模式的matcher方法从模式创建匹配器。
         * 创建后，可以使用匹配器执行三种不同类型的匹配操作：
         *  1.matches方法尝试将整个输入序列与模式进行匹配。
         *  2.lookingAt方法尝试将起始于输入序列的输入序列与模式进行匹配。
         *  3.find方法扫描输入序列，寻找匹配模式的下一个子序列。
         */
        Matcher m = p.matcher("aaaaab");

        boolean b = m.matches();
    }
}

package com.maolin.kaitong;

import com.maolin.util.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-10-29 11:12
 */
public class LableTest {

    @Test
    public void testLable(){
        String value = "18-109              112                 114-115             118-120             \n" +
                "123-168             171                 173                 175-180             \n" +
                "182-183             185-197             199-201             203-204             \n" +
                "206-810             812-1023  ";
        List<Integer> integers = queryMplsStaticLabelAvailable(value);
        System.out.println(integers);
    }

    public List<Integer> queryMplsStaticLabelAvailable(String data) {
        List<Integer> lspIdList = new ArrayList<Integer>();
        int tmp1 = 0;
        int tmp2 = 0;
        final int maxReturnSize = 1000;//最大返回个数
        String[] arr = data.split("\\s+");
        for(String s : arr){
            if(s == null || "".equals(s)){
                continue;
            }
            if(s.contains("-")){
                String[] arr2 = s.split("-");
                if(StringUtils.isNumber(arr2[0]) && StringUtils.isNumber(arr2[1])){
                    tmp1 = Integer.parseInt(arr2[0]);
                    tmp2 = Integer.parseInt(arr2[1]);
                    for(int i=tmp1; tmp1 <= i && i<=tmp2; i++){
                        lspIdList.add(i);
                        if(lspIdList.size() >= maxReturnSize){
                            return lspIdList;
                        }
                    }
                }

            }else{
                if(StringUtils.isNumber(s)){
                    tmp1 = Integer.parseInt(s);
                    lspIdList.add(tmp1);
                    if(lspIdList.size() >= maxReturnSize){
                        return lspIdList;
                    }
                }
            }
        }
        return lspIdList;
    }

}

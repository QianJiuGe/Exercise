package org.example.StudyFastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

public class StudyFastJson {

    //json字符串-简单对象型
    private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    /**
     * json字符串-简单对象型与JSONObject之间的转换
     */
    public static void testJSONStrToJSONObject(int i){

        JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(JSON_OBJ_STR); //因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println(i);
        System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));

    }

    public  void testJSONStrToJSONObject1(int i){

        JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(JSON_OBJ_STR); //因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println(i);
        System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));

    }

    @Test
    public void test(){
        /**
         * testJSONStrToJSONObject是静态方法  不建立对象都可以调用
         * 静态方法强调唯一性，因此不会因为对象的不同导致方法的不同
         */
        StudyFastJson.testJSONStrToJSONObject(2);

        /**
         * 非静态方法必须建立对象后才可以使用   因为可能方法会因为对象的不同而有所不同
         */
//        StudyFastJson studyFastJson = new StudyFastJson();
//        studyFastJson.testJSONStrToJSONObject1(5);
    }

}

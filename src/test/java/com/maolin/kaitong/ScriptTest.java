package com.maolin.kaitong;

import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2018-11-21 10:10
 */
public class ScriptTest {
    private Pattern pattern = Pattern.compile("<JavaScript>([\\s\\S]*)</JavaScript>");
    private ScriptEngineManager manager = new ScriptEngineManager();

    private void processScript(String script) {

    }

    private String getScript(String path) {
        try {
            List<String> strings = Files.readAllLines(Paths.get(path));
            //String script = strings.stream().collect(Collectors.joining("\n"));
            String script = String.join("\n", strings);
            Matcher matcher = pattern.matcher(script);
            if (matcher.find()) {
                String group = matcher.group(1);
                return group;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void exeScript(String script, String method, Object... params) {
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            engine.eval(script);
            Invocable invocable = (Invocable) engine;
            Object getScript = invocable.invokeFunction(method, params);
            System.out.println(getScript);
        } catch (ScriptException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    /**
     * https://www.cnblogs.com/top8/p/6207945.html
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException, ScriptException, NoSuchMethodException {
        String script = getScript("src/test/resources/script.txt");
        //System.out.println(collect);
        ScriptEngine engine = manager.getEngineByName("js");

        Map<String, String> scriptMap = new HashMap<>();
        scriptMap.put("npeType", "dynamic");
        engine.put("npeType", "dynamic");
        engine.eval(script);
        Invocable invocable = (Invocable) engine;
        Object getScript = invocable.invokeFunction("getScript", scriptMap);
        System.out.println(getScript);

    }

    @Test
    public void test2() {
        String script = getScript("src/test/resources/script2.txt");

        Map<String, Object> scriptMap = new HashMap<>();
        ScriptBeanOut outbean = new ScriptBeanOut();
        outbean.setName("外部bean");
        outbean.setAge(10);

        ScriptBeanIn inbean = new ScriptBeanIn();
        inbean.setName("内部bean");
        inbean.setAge(12);

        scriptMap.put("outbean", outbean);
        scriptMap.put("inbean", inbean);

        scriptMap.put("name", "nihao");
        scriptMap.put("age", 11);

        exeScript(script, "getScript", scriptMap);


    }

    @Test
    public void test4() {
        String script = getScript("src/test/resources/script3.txt");
        List<Map<String, Object>> upe = new ArrayList<>();

        Map<String, Object> upeScript1 = new HashMap<>();
        upeScript1.put("name", "张三");
        upeScript1.put("age", 11);
        upe.add(upeScript1);

        Map<String, Object> upeScript2 = new HashMap<>();
        upeScript2.put("name", "李四");
        upeScript2.put("age", 12);
        upe.add(upeScript2);

        Map<String, Object> upeScript3 = new HashMap<>();
        upeScript3.put("name", "王五");
        upeScript3.put("age", 13);
        upe.add(upeScript3);

        exeScript(script, "getScript", upe);
    }

    @Test
    public void test5(){
        String script = getScript("src/test/resources/script.txt");
        List<Map<String, Object>> upe = new ArrayList<>();
        Map<String, Object> upeScript1 = new HashMap<>();
        upeScript1.put("neId", "1.1.1.3");
        upeScript1.put("vcId", 10);
        upeScript1.put("aPwId", 10);
        upeScript1.put("zPwId", 10);
        upe.add(upeScript1);

        Map<String, Object> upeScript2 = new HashMap<>();
        upeScript2.put("neId", "1.1.1.3");
        upeScript2.put("vcId", 20);
        upeScript2.put("aPwId", 20);
        upeScript2.put("zPwId", 20);
        upe.add(upeScript2);

        Map<String, Object> upeScript3 = new HashMap<>();
        upeScript3.put("neId", "1.1.1.3");
        upeScript3.put("vcId", 30);
        upeScript3.put("aPwId", 30);
        upeScript3.put("zPwId", 30);
        upe.add(upeScript3);

        Map<String, Object> upeScript4 = new HashMap<>();
        upeScript4.put("neId", "1.1.1.3");
        upeScript4.put("vcId", 40);
        upeScript4.put("aPwId", 40);
        upeScript4.put("zPwId", 40);
        upe.add(upeScript4);

        exeScript(script, "getScript", upe);
    }

    class ScriptBeanIn {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "牛逼：ScriptBeanIn{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
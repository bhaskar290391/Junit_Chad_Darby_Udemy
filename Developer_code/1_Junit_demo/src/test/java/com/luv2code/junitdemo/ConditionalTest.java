package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTest {

    @Test
    @Disabled("Disabled Test")
    void disabledTest(){

    }

    @Test
    @EnabledOnOs(OS.MAC)
    void enabledOnMac(){
    }


    @Test
    @EnabledOnOs(OS.WINDOWS)
    void enabledOnWindows(){
    }



    @Test
    @EnabledOnOs(OS.LINUX)
    void enabledOnLinux(){
    }



    @Test
    @EnabledOnOs({OS.MAC,OS.WINDOWS})
    void enabledOnMacWindow(){
    }


    //Test for Enable for JRE


    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void enabledOnJava8(){
    }


    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void enabledOnJava17(){
    }


    @Test
   @EnabledForJreRange(min = JRE.JAVA_8,max = JRE.JAVA_17)
    void enabledOnJavaRange(){
    }


    @Test
    @EnabledForJreRange(min = JRE.JAVA_17)
    void enabledOnJavaRangeMin(){
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "bhaskar_ENV",matches = "bhaskar")
    void envVariableTest(){}


    @Test
    @EnabledIfSystemProperty(named = "bhaskar_SYS",matches = "bhaskar")
    void systemVariableTest(){}
}

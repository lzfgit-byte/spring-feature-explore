
import com.ilzf.testjunit.JunitApplication;
import com.ilzf.testjunit.service.JunitService;
import com.ilzf.util.LogUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.awt.*;
import java.util.Random;

import static org.junit.jupiter.api.condition.JRE.*;
import static org.junit.jupiter.api.condition.OS.*;

/**
 * Assertions的方法抛出异常意味着测试不通过，
 * Assumptions的方法抛出异常意味着测试被跳过(为什么称为"跳过"？因为mvn test的执行结果被标记为Skipped)；
 */
@SpringBootTest(classes = JunitApplication.class)
@DisplayName("A special test case")
public class ApplicationTest {

    @Autowired
    JunitService junitService;

    @BeforeAll
    public static void beforeAll() {
        LogUtil.log("test beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        LogUtil.log("test afterAll");
    }

    @BeforeEach
    public void beforeEach() {
        LogUtil.log("test beforeEach");
    }

    @AfterEach
    void afterEach() {
        LogUtil.log("test AfterEach");
    }


    @Test
    public void test() {
        Assert.isTrue(junitService.say(), "不通过");
        Assertions.assertTrue(junitService.say());
    }


    @Test
    @DisplayName("测试2")
    public void test2() {
        Random random = new Random();
        int a = random.nextInt(10);
        LogUtil.log(a);
        Assertions.assertTrue(a > 4, "小于四");
    }

    @Test
    public void test3() {
        Assumptions.assumeTrue("abc".contains("Z"));
        Assertions.fail("test should have been aborted");
    }

    @Disabled("演示禁用")
    @Test
    public void test4() {
        LogUtil.log("test4");
    }

    @Test
    @EnabledOnOs({LINUX, MAC})
    public void test5() {
        LogUtil.log("test4");
    }

    @Test
    @DisabledOnOs({WINDOWS})
    public void test6() {
        LogUtil.log("test4");
    }

    @Test
    @EnabledOnJre({JAVA_9, JAVA_10})
    void onJava9Or10() {
        // ...
    }

    @Test
    @EnabledForJreRange(min = JAVA_9, max = JAVA_11)
    void fromJava9to11() {
        // ...
    }

    @Test
    @DisabledOnJre(JAVA_9)
    void notOnJava9() {
        // ...
    }

    @Test
    @DisabledForJreRange(min = JAVA_9, max = JAVA_11)
    void notFromJava9to11() {
        // ...
    }


}

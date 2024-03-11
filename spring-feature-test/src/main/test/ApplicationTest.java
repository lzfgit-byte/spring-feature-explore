
import com.ilzf.testjunit.JunitApplication;
import com.ilzf.testjunit.service.JunitService;
import com.ilzf.util.LogUtil;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Random;


@SpringBootTest(classes = JunitApplication.class)
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
    public void test2() {
        Random random = new Random();
        int a = random.nextInt(10);
        LogUtil.log(a);
        Assertions.assertTrue(a > 4, "小于四");
    }
}


import com.ilzf.testjunit.JunitApplication;
import com.ilzf.testjunit.service.JunitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest(classes = JunitApplication.class)
public class ApplicationTest {

    @Autowired
    JunitService junitService;

    @Test
    public void test() {
        Assert.isTrue(junitService.say(), "不通过");
    }
}

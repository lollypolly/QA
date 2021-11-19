package ru.itlab.qa.tests;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QaDeleteBoardTest extends TestBase {
    @After
    public void end(){
        tearDown();
    }

    @SneakyThrows
    @Test
    public void testDeletePost() {
        auth();
        deleteLastPost();
    }

}

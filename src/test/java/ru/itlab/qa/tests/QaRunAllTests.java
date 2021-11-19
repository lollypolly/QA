package ru.itlab.qa.tests;

import lombok.SneakyThrows;
import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QaRunAllTests extends TestBase {
    @AfterClass
    public static void end(){
        tearDown();
    }

    @SneakyThrows
    @Test
    public void testAuth() {
        auth();
    }

    @SneakyThrows
    @Test
    public void testCreatePost() {
        createNewPost();
    }

    @SneakyThrows
    @Test
    public void testDeletePost() {
        deleteLastPost();
    }
}

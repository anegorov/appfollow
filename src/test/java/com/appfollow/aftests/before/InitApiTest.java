package com.appfollow.aftests.before;

import com.appfollow.aftests.rest.Calls;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class InitApiTest {

    @Autowired @Lazy protected Calls calls;

}

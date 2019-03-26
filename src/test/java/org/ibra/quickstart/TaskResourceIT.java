package org.ibra.quickstart;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.SubstrateTest;

@SubstrateTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class TaskResourceIT extends TaskResourceTest {

}

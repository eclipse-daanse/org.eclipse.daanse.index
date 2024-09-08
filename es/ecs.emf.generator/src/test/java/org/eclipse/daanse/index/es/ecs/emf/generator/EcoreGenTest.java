package org.eclipse.daanse.index.es.ecs.emf.generator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class EcoreGenTest {

    @Test
    void generate() throws IOException {

        Path rootFolder=Paths.get("./src/main/resources/ecsschemas/");

        System.out.println(rootFolder.toAbsolutePath().toString());
        EcoreGen ecoreGen=new EcoreGen();
        ecoreGen.generate(rootFolder);
    }
}

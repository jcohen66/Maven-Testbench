package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by jcohen66 on 12/30/14.
 */
public class TimeBoxedTest {

    final int TIMEOUT = 5009;

    long start = 0;
    long elapsed = 0;

    @Before
    public void setup() {
        start = System.currentTimeMillis();
    }

    @After
    public void teardown() {
        elapsed = System.currentTimeMillis() - start;
        System.out.printf("\nTimeboxedTest Elapsed time: %d ms\n\n", elapsed );
    }

    @Test(timeout=TIMEOUT)
    public void timedTest() throws IOException {

        String srcName = "200S_1.jpg";
        File srcFile = new File(srcName);

        BufferedImage image = null;
        image = ImageIO.read(srcFile);

        System.out.println("Source image: " + srcName);

        BufferedImage blurredImage = ForkBlur.blur(image);

        String dstName = "200S_1-101.jpg";
        File dstFile = new File(dstName);
        ImageIO.write(blurredImage, "jpg", dstFile);

        System.out.println("Output image: " + dstName);

    }
}

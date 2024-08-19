package dev.thinke;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.apache.commons.codec.binary.Hex.encodeHex;

public class RandomTest {

    @Test
    public void byteTest() {
        final var phrase = "Hello World";
        final var bytes = phrase.getBytes(Charset.defaultCharset());
        final var newPhrase = new String(bytes, StandardCharsets.UTF_8);
        for (char b : phrase.toCharArray()) {
            System.out.println(b);
        }
        System.out.println(Arrays.toString(bytes));
        System.out.println(newPhrase);
    }
}

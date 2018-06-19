package com.example.demo.nio;

import javax.crypto.SecretKey;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.HashSet;
import java.util.Set;

public class CharsetTest {
    public static void main(String[] args) {
        encodeByCharset("iso-8859-1");
    }

    private static void encodeByCharset(String charset) {
        Charset cs = Charset.forName(charset);
        CharsetEncoder charsetEncoder = cs.newEncoder();
        String str = "Hello world!";
        try {
            ByteBuffer buffer = charsetEncoder.encode(CharBuffer.wrap(str));
            System.out.println("ok");
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
    }
}

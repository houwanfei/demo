package com.example.demo.test;


import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 * @auther houwanfei
 * @create 2018-02-26 下午5:46
 */
public class HtmlParserDemo {
    public static void main(String[] args) {
        Parser parser;
        try {
            parser = new Parser("http://www.baidu.com");
            NodeFilter filter = new TagNameFilter("img");
            NodeList nodeList = parser.extractAllNodesThatMatch(filter);
            for (int i = 0; i < nodeList.size(); i++) {
                ImageTag node = (ImageTag) nodeList.elementAt(i);
                System.out.println(node.getAttribute("src"));
            }
        }  catch (ParserException e) {
            e.printStackTrace();
        }
    }
}

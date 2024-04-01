package com.example.demo.util;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

public class Util {
    public static String cleanHtmlContent(String htmlContent) {
        return Jsoup.clean(htmlContent, Safelist.basic());
    }
}
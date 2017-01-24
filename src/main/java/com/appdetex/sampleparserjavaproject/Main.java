package com.appdetex.sampleparserjavaproject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * Main Java Class
 * <p>
 * This class will use Jsoup to retrieve a provided URL
 * and parse out certain data, printing that data to
 * stdout in a JSON format.
 */
public class Main {

    public static void main(String[] args) throws IOException {

//        if (args.length <= 0 || args.length> 1) {
//            System.err.println("TODO: Print usage");
//            return;
//        }

//        Parser p = new Parser(new URL(args[0]));

        // Testing initial stuff
        URL testUrl = new URL("https://play.google.com/store/apps/details?id=com.exozet.game.carcassonne");
        Document document = Jsoup.connect(testUrl.toString()).get();
        Parser p = new Parser(document);
        AppData foundData = p.parse();
        System.out.println(foundData.toJson());

    }

}

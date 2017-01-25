package com.appdetex.sampleparserjavaproject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
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

        if (args.length <= 0 || args.length> 1) {
            printUsage();
            return;
        }

        try {
            URL url = new URL(args[0]);
            Document document = Jsoup.connect(url.toString()).get();
            Parser p = new Parser(document);
            AppData foundData = p.parse();
            System.out.println(foundData.toJson());
        } catch (MalformedURLException mue) {
            System.err.println("You passed in an invalid url.");
            printUsage();
        }

    }

    public static void printUsage() {
        System.out.println("Requires 1 argument as a valid google play app url. Example: https://play.google.com/store/apps/details?id=com.exozet.game.carcassonne");
    }

}

package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class BJ1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        Map<String, Integer> books = new HashMap<>();

        int bestSeller = 0;

        for (int i = 0; i < N; i++) {
            String bookTitle = br.readLine();
            books.put(bookTitle, books.getOrDefault(bookTitle, 0) + 1);
            bestSeller = Math.max(bestSeller, books.get(bookTitle));
        }

        ArrayList<String> bestSellers = new ArrayList<>();

        for (Map.Entry<String, Integer> book : books.entrySet()) {
            if (book.getValue() == bestSeller) bestSellers.add(book.getKey());
        }

        Collections.sort(bestSellers);
        System.out.println(bestSellers.get(0));
    }
}

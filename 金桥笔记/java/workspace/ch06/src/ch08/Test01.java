package ch08;

import java.util.Scanner;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/15
 * @Version 1.0
 */

public class Test01 {
    public static void main(String[] args) {
        String[] songs = {"Island","Ocean","Pretty","Sun"};
        System.out.println("插入的歌曲");
        for (int i = 0; i < songs.length; i++) {
            System.out.println(songs[i]+"\t");

        }
        Scanner input = new Scanner(System.in);
        System.out.println("请输入新歌曲");
        String newsong = input.next();
        String[] newsongs = new String[songs.length+1];
        for (int i = 0; i < songs.length; i++) {
            newsongs[i] = songs[i];
        }
        int index = newsongs.length-1;
        for (int i = 0; i < newsongs.length-1; i++) {
            if (newsongs[i].compareToIgnoreCase(newsong)>0){
                index = i;
                break;
            }
        }
        for (int i = newsongs.length-1; i >index  ; i--) {
            newsongs[i] = newsongs[i-1];

        }
        newsongs[index] =newsong;
        System.out.println("插入之后的歌曲是");
        for (int i = 0; i < newsongs.length; i++) {
            System.out.println(newsongs[i]+"\t");

        }
    }
}

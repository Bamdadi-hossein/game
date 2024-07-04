package org.example.demo4;

import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Block1 {
    //تعریف باکس جدید برای اضافه کردن به اچ باکس انمی باکس
    public static Rectangle newBox;

    //ساخت یک اری لیست همگام با اچ باکس انمی باکس برای مشخص کردن موقعیت انمی‌ها
    public static AbstractList<Integer> enemies = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0));
    //متد تعیین نوع باکس جدید اچ باکس انمی باکس
    public static void getColer () throws FileNotFoundException {
    //entekhab adad random beyn 1-3
        Random random = new Random();
        int entekhab = random.nextInt(1,4);
        //اگر عدد رندم ۲ یا ۳ بود یک بلاک  معمولی غیر از انمی تولید کند
        if (entekhab == 2 || entekhab == 3){
            //set kardan  noa khane akhar
            enemies.set(7, 0);
            newBox = new Rectangle(70, 70);
            newBox.setFill(Color.NAVY);
    //اگر عدد رندم 1 بود یک بلاک انمی تولید کند
        } else if (entekhab == 1) {
            //set kardan  noa khane akhar
            enemies.set(7, 1);
            newBox = new Rectangle(70, 70);

            FileInputStream FileImage = new FileInputStream("C:\\Users\\afraa\\Desktop\\B\\D\\java porojects\\demo4\\src\\main\\resources\\org\\example\\demo4\\enemy.png");
            Image image = new Image(FileImage);
            ImagePattern imagePattern = new ImagePattern(image);
            newBox.setFill(imagePattern);
        }
    }
}

package org.example.demo4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Game extends Application {

//تولید یک hbox برای قرار دادن بلاک های مربوط به جون کارکتر در ان
    public static HBox HJOOn = new HBox();
//تعیین حداکثر مقدار بلاک های قابل قرار گیری در hbox ، blockbox
    private static final int MAX_BOXES = 10;
    //تعیین نوع و سطح دسترسی بلاک کارکتر
    private Rectangle shovalye;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {


        // ایجاد یک HBox برای بلوک‌ها
        HBox blockBox = new HBox();
        blockBox.setSpacing(2); // فاصله بین بلوک‌ها
        blockBox.setLayoutY(620);


        // ایجاد یک HBox برای دشمنان
        HBox enemyBox = new HBox();
        enemyBox.setSpacing(2); // فاصله بین بلوک‌ها
        enemyBox.setLayoutY(550);

        // ایجاد دکمه‌ها
        Button button1 = new Button("MOVE");
        Button button2 = new Button("FIGHT");
        //تعیین سایز دکمه ها
        button1.setPrefHeight(90);
        button2.setPrefHeight(90);
        button1.setPrefWidth(90);
        button2.setPrefWidth(90);
        //تعیین عملکرد دکمه ی move

        button1.setOnAction(actionEvent -> {
            try {
                addNewBox(blockBox);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                addNewEnemy(enemyBox, primaryStage);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });




        // va taean mogheyat on قرار دادن دکمه‌ها در یک HBox
        HBox buttonBox = new HBox(10, button1, button2);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setLayoutY(700);
        buttonBox.setLayoutX(200);


        //ایجاد 3 مستطیل و اضافه کردن آنها به hjoon
        for (int i = 0; i < 3; i++) {
            Rectangle block = new Rectangle(70, 70);
            FileInputStream FileImage = new FileInputStream("C:\\Users\\afraa\\Desktop\\B\\D\\java porojects\\demo4\\src\\main\\resources\\org\\example\\demo4\\ghalb.png");
            Image image = new Image(FileImage);
            ImagePattern imagePattern = new ImagePattern(image);
            block.setFill(imagePattern);



            HJOOn.getChildren().add(block);
        }


        // ایجاد 8 مستطیل و اضافه کردن آنها به blockbox
        for (int i = 0; i < 8; i++) {
            Rectangle block = new Rectangle(70, 70);
            FileInputStream FileImage = new FileInputStream("C:\\Users\\afraa\\Desktop\\B\\D\\java porojects\\demo4\\src\\main\\resources\\org\\example\\demo4\\A.png");
            Image image = new Image(FileImage);
            ImagePattern imagePattern = new ImagePattern(image);
            block.setFill(imagePattern);
            blockBox.getChildren().add(block);
        }
         // ایجاد 8 مستطیل و اضافه کردن آنها به enemybox
        for (int i = 0; i < 8; i++) {
            Rectangle block = new Rectangle(70, 70);

            block.setFill(Color.NAVY);

            enemyBox.getChildren().add(block);
        }

        // ایجاد یک Region برای پس‌زمینه سورمه‌ای
        Region background = new Region();
        background.setPrefSize(600, 800);
        background.setStyle("-fx-background-color: navy;");


    //ساختن بلاک شوالیه و تعیین موقعیت ان
        shovalye = new Rectangle(70, 70);
        FileInputStream FileImage = new FileInputStream("C:\\Users\\afraa\\Desktop\\B\\D\\java porojects\\demo4\\src\\main\\resources\\org\\example\\demo4\\sh.png");
        Image image = new Image(FileImage);
        ImagePattern imagePattern = new ImagePattern(image);
//            newBox = new Rectangle(70, 70);
        shovalye.setFill(imagePattern);

        shovalye.setLayoutX(218.5);
        shovalye.setLayoutY(550);

    // تعیین عملکرد دکمه دوم یا همون فایت
        button2.setOnAction(actionEvent -> {
            if (Block1.enemies.get(4) == 1){
                Block1.enemies.set(4, 0);
                Rectangle blockEnemy = new Rectangle(70, 70);
                blockEnemy.setFill(Color.NAVY);
                enemyBox.getChildren().set(4, blockEnemy);
            }
        });



        // ایجاد یک group root
        // قرار دادن پس‌زمینه در مرکز group root
        Group root = new Group(background);


        //قرار دادن اچ باکس بلاک باکس در گروپ روت
        root.getChildren().add(blockBox);
    //قرار دادن اچ باکس باتن باکس در گروپ روت
        root.getChildren().add(buttonBox);
        // قرار دادن اچ باکس انمی باکس در گروپ روت
        root.getChildren().add(enemyBox);
    // قرار دادن بلاک شوالیه در گروپ روت
        root.getChildren().add(shovalye);
        //قرار دادن اچ باکس اچ جووون در گروپ روت
        root.getChildren().add(HJOOn);



        // ایجاد صحنه با ابعاد 800 در 600
        Scene scene = new Scene(root, 600, 800);

        // تنظیم عنوان و صحنه برای Stage اصلی
        primaryStage.setTitle("HOPPENHELM");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    //تابع اضافه کردن بلاک جدید
    private void addNewBox(HBox hbox) throws FileNotFoundException {
        // ایجاد باکس جدید
        Rectangle newBox = new Rectangle(70, 70);
//        newBox.setFill(Color.LIGHTGRAY);
        FileInputStream FileImage = new FileInputStream("C:\\Users\\afraa\\Desktop\\B\\D\\java porojects\\demo4\\src\\main\\resources\\org\\example\\demo4\\A.png");
        Image image = new Image(FileImage);
        ImagePattern imagePattern = new ImagePattern(image);
//            newBox = new Rectangle(70, 70);
        newBox.setFill(imagePattern);





        // افزودن باکس جدید به ابتدای HBox
        hbox.getChildren().add(8, newBox);

        // اگر تعداد باکس‌ها از حد مجاز بیشتر شود، آخرین باکس حذف شود
        if (hbox.getChildren().size() > MAX_BOXES) {
            hbox.getChildren().remove(0);
        }
    }

    //تابع اضافه کردن اینمی یا بلاک جدید
    private void addNewEnemy(HBox hbox, Stage primaryStage) throws FileNotFoundException {
    //شیفت دادن اعضای اریلیست به چپ
//        Block1.enemies.remove(0);
        for (int i =0 ; i <7 ; i++){
            Block1.enemies.set(i , Block1.enemies.get(i+1));
        }
        //فراخوانی تابع اضافه کردن انمی جدید در کلاس بلاک وان
        Block1.getColer();

        // افزودن باکس جدید به ابتدای enemyBox

        hbox.getChildren().add(8, Block1.newBox);

        // اگر تعداد باکس‌ها از حد مجاز بیشتر شود، آخرین باکس حذف شود
        if (hbox.getChildren().size() > MAX_BOXES) {
            hbox.getChildren().remove(0);
        }
        //اگر در خانه شوالیه انمی وجود داشته باشد یک جون از جون‌های شوالیه کم شود
        if (Block1.enemies.get(3) == 1){
            HJOOn.getChildren().remove(0);
            Player.setJoon();
        }
        //اگر تعداد جون شوالیه برابر صفر است آنگاه بازی خاتمه یابد
        if (Player.getJoon() == 0){
            primaryStage.close();
        }
    }
    //تابع مین برای اجرا و لانچ بازی
    public static void main(String[] args) {
        launch(args);
    }
}
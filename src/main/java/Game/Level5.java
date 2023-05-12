package Game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Level5 extends Application {

    private Text trollLifeText;
    private int trollLife = 10;

    @Override
    public void start(Stage primaryStage) throws Exception {

        RadioButton wand1RadioButton;
        RadioButton wand2RadioButton;

        // 创建两个Image对象
        FileInputStream input = new FileInputStream("src/main/Image/Dolores.jpg");
        Image trollImage = new Image(input);
        FileInputStream input2 = new FileInputStream("src/main/Image/Harry.jpg");
        Image harryImage = new Image(input2);

        // 创建两个ImageView对象，并将Image对象添加到其中
        ImageView trollImageView = new ImageView(trollImage);
        ImageView harryImageView = new ImageView(harryImage);
        harryImageView.setFitHeight(500);
        harryImageView.setFitWidth(500);
        trollImageView.setFitHeight(500);
        trollImageView.setFitWidth(750);

        // 创建两个Text对象，用于显示生命值
        Text harryLifeText = new Text("10");
        trollLifeText = new Text(String.valueOf(trollLife));

        // 设置生命值文本的字体
        harryLifeText.setFont(Font.font("Arial", 20));
        trollLifeText.setFont(Font.font("Arial", 20));

        // 创建VBox布局管理器，用于包含Troll图像和生命值
        VBox trollBox = new VBox();
        trollBox.getChildren().addAll(trollImageView, trollLifeText);
        trollBox.setAlignment(Pos.CENTER);
        trollBox.setSpacing(20);

        // 创建VBox布局管理器，用于包含Harry图像、攻击按钮和生命值
        VBox harryBox = new VBox();
        harryBox.getChildren().addAll(harryImageView, createAttackButton(), harryLifeText);
        harryBox.setAlignment(Pos.CENTER);
        harryBox.setSpacing(20);

        // 创建HBox布局管理器，用于包含HarryBox和TrollBox
        HBox hbox = new HBox();
        hbox.getChildren().addAll(harryBox, trollBox);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(100);

        // 创建BorderPane布局管理器，并将HBox添加到其中
        BorderPane root = new BorderPane();
        root.setCenter(hbox);
        root.setPadding(new Insets(20));

        // 创建场景
        Scene scene = new Scene(root);

        // 将场景添加到舞台
        primaryStage.setScene(scene);

        // 设置舞台标题
        primaryStage.setTitle("Level 1");

        // 显示舞台
        primaryStage.show();
    }

    private Button createAttackButton() {
        Button button = new Button("Attack");
        button.setOnAction(event -> {
            trollLife--;
            trollLifeText.setText(String.valueOf(trollLife));
            if (trollLife < 1) {
                showGameWonDialog();
                System.exit(0);
            }
        });
        return button;
    }

    private void showGameWonDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText("Congratulations!");
        alert.setContentText("Troll is dead！");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

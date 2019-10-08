/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discoverdublin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;


/**
 *
 * @author Admin
 */
public class DiscoverDublin extends Application {
    Stage stage;
    MediaView mediaView1;
    boolean  flag;
    
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, URISyntaxException {
        stage = primaryStage;
        // Create the login form grid pane
        //gridPane = createLoginFormPane();
        // Add UI controls to the registration form grid pane
        //addUIControls(gridPane);
        // Create a pane for main window
        GridPane gridPane = createMainwindowPane();
      
       
        
            // Add UI controls to the registration form grid pane
            addMainWindowUIControls(gridPane);


            Scene scene = new Scene(gridPane, 900, 700);
            
            primaryStage.setTitle("Discover Dublin");
            primaryStage.setScene(scene);
            addUIControls(primaryStage);
           
            //primaryStage.show();
        
    }
    private GridPane createLoginFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(60, 100, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }
    private GridPane createMainwindowPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(Stage pStage) throws FileNotFoundException {
        
        
        GridPane gridPane = new GridPane();
        Stage newStage = new Stage();
        newStage.setTitle("Login");
        
       
        gridPane.setBackground(new Background(new BackgroundFill(Color.MEDIUMSLATEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        // Add Header
        Label headerLabel = new Label("Discover Dublin");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        headerLabel.setTextFill(Color.web("#800080"));
        gridPane.add(headerLabel, 2,0,3,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        //GridPane.setMargin(headerLabel, new Insets(20, 0,20,0)); 
        Image image = new Image(new FileInputStream("flag.jpg")); 
        //Setting the image view 
        ImageView imageView = new ImageView(image); 
     
      //setting the fit height and width of the image view 
      imageView.setFitHeight(200); 
      imageView.setFitWidth(150); 
      
      //Setting the preserve ratio of the image view 
      imageView.setPreserveRatio(true);
      
      gridPane.add(imageView, 1, 2,1,3);
      GridPane.setMargin(imageView, new Insets(20, 0,0,0));
      
        // Add Email Label
        Label userName = new Label("Username");
        gridPane.add(userName, 2, 2);
        GridPane.setHalignment(userName, HPos.LEFT);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        
        // Add Email Text Field
        TextField userNameField = new TextField();
        userNameField.setPrefHeight(40);
        //userNameField.setMaxWidth(100);
        gridPane.add(userNameField, 2, 3);

        // Add Password Label
        Label passwordLabel = new Label("Password");
        gridPane.add(passwordLabel, 2, 4);
        GridPane.setHalignment(passwordLabel, HPos.LEFT);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 2, 5);

        // Add Submit Button
        Button submitButton = new Button("Login");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 2, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.RIGHT);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
        Scene scene = new Scene (gridPane, 600, 400);
        newStage.setScene(scene);
        newStage.show();

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(userNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your username");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                }
                
                if(userNameField.getText().equals("dorset") && passwordField.getText().equals("1234")){
                         newStage.close();
                         pStage.show();
                       // Add UI controls to the registration form grid pane
                       //addMainWindowUIControls(gridPane); 
                    //gridPane.getScene().getWindow().getOnCloseRequest();
                }else{
                    
                     //flag = false;
                     showAlert(Alert.AlertType.WARNING, gridPane.getScene().getWindow(), "Login failed!", "Invalid username/password!!!");
                }
                    
            }
        });
       
       
        
    }
    private void addMainWindowUIControls(GridPane gridPane) throws FileNotFoundException, URISyntaxException {
        gridPane.setBackground(new Background(new BackgroundFill(Color.MEDIUMSLATEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        // Add Header
        Label headerLabel = new Label("Discover Dublin");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 48));
        headerLabel.setTextFill(Color.web("#800080"));
        gridPane.add(headerLabel, 1,0);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
       //GridPane.setMargin(headerLabel, new Insets(20, 0,20,0)); 
        Image image = new Image(new FileInputStream("flag.jpg")); 
      //Setting the image view 
      ImageView imageView = new ImageView(image); 
      
      //setting the fit height and width of the image view 
      imageView.setFitHeight(70); 
      imageView.setFitWidth(50); 
      
      //Setting the preserve ratio of the image view 
      imageView.setPreserveRatio(true);
      
      gridPane.add(imageView, 3, 0);
      GridPane.setMargin(imageView, new Insets(20, 0,0,0));
      
        // Add history button
        Button btnHistory = new Button("History");
        btnHistory.setMaxWidth(Double.MAX_VALUE);
        btnHistory.setStyle("-fx-background-color: #87CEFA;");
        gridPane.add(btnHistory, 0, 1);
        GridPane.setHalignment(btnHistory, HPos.LEFT);
        //history content
        BorderPane historyPane = new BorderPane();
        BorderPane linksPane = new BorderPane();
        BorderPane placesPane = new BorderPane();
        BorderPane videosPane = new BorderPane();
        ScrollPane QuizPane = new ScrollPane();
        // menu option 1: adding element to history pane
        String historyText="History of Dublin\n\n A not so brief history of Dublin. The first known settlement was Ath Cliath,\n"
                + "which took its name from a major ford across the tider River Liffry. At around\n the sixth"
                + "century a monastery Duiblinn(blackpoll) was fouded due south of\n the tidal pool in the River Poddle, a tributary of the Liffeyon the south bank.\n\n\n";
        historyPane.setCenter(createLabel(historyText,Color.BLACK, Color.WHITE, 16));
        gridPane.add(historyPane, 1, 1,2,6);
        GridPane.setHalignment(historyPane, HPos.LEFT);
        
        //menu option links
        String linksTextHeading="Website Links";
        linksPane.setTop(createLabel(linksTextHeading,Color.PURPLE, Color.MEDIUMSLATEBLUE, 20));
        String linksText="https://www.visitdublin.com\n\nhttps://lovindublin.com/lifestyle/10-of-the-best-places-to-spend-the-day-in-dublin-that-wont-cost-you-a-penney";
        linksPane.setCenter(createLabel(linksText,Color.BLACK, Color.MEDIUMSLATEBLUE, 16));
        gridPane.add(linksPane, 1, 1,2,6);
        GridPane.setHalignment(linksPane, HPos.LEFT);
        linksPane.setVisible(false);
          
          
        //play audio 
        ComboBox audioList = new ComboBox();
        audioList.getItems().addAll("select","05_Reels__The_The_Maids_of_Castlebar_The_Swallow_s_Nest.mp3","08_Polkas__Seamus_Creagh_s_Trip_to_Dingle.mp3");
        audioList.setPromptText("Select audio");
        audioList.setEditable(true);        
        audioList.valueProperty().addListener(new ChangeListener<String>() {
        @Override public void changed(ObservableValue ov, String t, String t1) {
          
        //menu option places
        String pathAudio = "resources\\audios\\"+t1; 
        //Instantiating Media class  
        Media media = new Media(new File(pathAudio).toURI().toString()); 
        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        //by setting this property to true, the audio will be played   
        if(t1.equals("select"))
          mediaPlayer.setAutoPlay(false);
        else
            mediaPlayer.setAutoPlay(true);
        }    
    });
        placesPane.setTop(audioList);
        //linksPane.setCenter(createLabel(linksText,Color.BLACK, Color.MEDIUMSLATEBLUE, 16));
        gridPane.add(placesPane, 1, 1,2,6);
        GridPane.setHalignment(placesPane, HPos.LEFT);
        placesPane.setVisible(false);
        
         //play videos
        ComboBox videosList = new ComboBox();
        
        videosList.getItems().addAll("select","vid1.mp4","vid2.mp4","vid3.mp4");
        videosList.setPromptText("Select video");
        videosList.setEditable(true);        
        videosList.valueProperty().addListener(new ChangeListener<String>() {
        @Override public void changed(ObservableValue ov, String t, String t1) {
          
        //menu option video
        String pathVideo = "resources\\videos\\"+t1; 
        //Instantiating Media class  
        Media media = new Media(new File(pathVideo).toURI().toString()); 
        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        //by setting this property to true, the audio will be played   
        mediaView1 = new MediaView (mediaPlayer);
        videosPane.setCenter(mediaView1);
        mediaPlayer.setAutoPlay(true);
        
        }    
    });
        videosPane.setTop(videosList);
        //linksPane.setCenter(createLabel(linksText,Color.BLACK, Color.MEDIUMSLATEBLUE, 16));
        gridPane.add(videosPane, 1, 1,2,6);
        GridPane.setHalignment(videosPane, HPos.LEFT);
        videosPane.setVisible(false);
        
        
        ScrollPane galleryPane = new ScrollPane();
        TilePane tile = new TilePane();
       galleryPane.setStyle("-fx-background-color: DAE6F3;");
        tile.setPadding(new Insets(15, 15, 15, 15));
        tile.setHgap(15);

        String path ="resources\\images\\";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        System.out.println("Images: "+listOfFiles.length);

        for (final File file : listOfFiles) {
                ImageView imageView1 = createImageView(file); 
                tile.getChildren().addAll(imageView1);
        }


        galleryPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // Horizontal
        galleryPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scroll bar
        galleryPane.setFitToWidth(true);
        galleryPane.setContent(tile);
        
        gridPane.add(galleryPane,1, 1,2,6);
        galleryPane.setVisible(false);
        btnHistory.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    historyPane.setVisible(true);
                    linksPane.setVisible(false);
                    galleryPane.setVisible(false);
                    placesPane.setVisible(false);
                    videosPane.setVisible(false);
                    linksPane.setVisible(false);
                    QuizPane.setVisible(false);
                   
                }
            }
       );
       
        
        
        // Add places button
        Button btnPlaces = new Button("Places");
        btnPlaces.setMaxWidth(Double.MAX_VALUE);
        btnPlaces.setStyle("-fx-background-color: #87CEFA;");
        gridPane.add(btnPlaces, 0, 2);
        GridPane.setHalignment(btnPlaces, HPos.LEFT);
        btnPlaces.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    
                    historyPane.setVisible(false);
                    linksPane.setVisible(false);
                    galleryPane.setVisible(false);
                    placesPane.setVisible(true);
                    videosPane.setVisible(false);
                    linksPane.setVisible(false);
                    QuizPane.setVisible(false);
                    
                }
            }
       );
        
        // Add gallery button
        Button btnGallery = new Button("Gallery");
        btnGallery.setMaxWidth(Double.MAX_VALUE);
        btnGallery.setStyle("-fx-background-color: #87CEFA;");
        gridPane.add(btnGallery, 0, 3);
        GridPane.setHalignment(btnGallery, HPos.LEFT);
        btnGallery.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    historyPane.setVisible(false);
                    linksPane.setVisible(false);
                    galleryPane.setVisible(true);
                    placesPane.setVisible(false);
                    videosPane.setVisible(false);
                    linksPane.setVisible(false);
                    QuizPane.setVisible(false);
                }
            }
       );
        
        // Add videos button
        Button btnVideos = new Button("Videos");
        btnVideos.setMaxWidth(Double.MAX_VALUE);
        btnVideos.setStyle("-fx-background-color: #87CEFA;");
        gridPane.add(btnVideos, 0, 4);
        GridPane.setHalignment(btnVideos, HPos.LEFT);
        btnVideos.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    historyPane.setVisible(false);
                    linksPane.setVisible(false);
                    galleryPane.setVisible(false);
                    placesPane.setVisible(false);
                    videosPane.setVisible(true);
                    linksPane.setVisible(false);
                    QuizPane.setVisible(false);
                }
            }
       );
        
        
       
        // Add links button
        Button btnLinks = new Button("Links");
        btnLinks.setMaxWidth(Double.MAX_VALUE);
        btnLinks.setStyle("-fx-background-color: #87CEFA;");
        gridPane.add(btnLinks, 0, 5);
        GridPane.setHalignment(btnLinks, HPos.LEFT);
        
        
        btnLinks.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    historyPane.setVisible(false);
                    linksPane.setVisible(false);
                    galleryPane.setVisible(false);
                    placesPane.setVisible(false);
                    videosPane.setVisible(false);
                    linksPane.setVisible(true); 
                    QuizPane.setVisible(false);
                }
            }
        );
        
        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        ToggleGroup group3 = new ToggleGroup();
        ToggleGroup group4 = new ToggleGroup();
        
        
        VBox vbQuiz = new VBox(20);
        HBox hb1 = new HBox(10);
        HBox hb2 = new HBox(10);
        HBox hb3 = new HBox(10);
        HBox hb4 = new HBox(10);
        //group 1
        Label ques1 = new Label("1. What is the capital of Ireland?");
        Label ques2 = new Label("2. What is the national language of Ireland?");
        Label ques3 = new Label("3. What is the population (million) in Ireland?");
        Label ques4 = new Label("4. Which province has the fewest counties?");
        Button btnAnswer = new Button("Submit");
        RadioButton rb11 = new RadioButton("Dublin");
        hb1.getChildren().add(rb11);
        rb11.setToggleGroup(group1);
        RadioButton rb12 = new RadioButton("Cork");
        hb1.getChildren().add(rb12);
        rb12.setToggleGroup(group1);
        RadioButton rb13 = new RadioButton("Galway");
        hb1.getChildren().add(rb13);
        rb13.setToggleGroup(group1);
        
        vbQuiz.getChildren().add(ques1);
        vbQuiz.getChildren().add(hb1);
        
        RadioButton rb21 = new RadioButton("Irish");
        hb2.getChildren().add(rb21);
        rb21.setToggleGroup(group2);
        RadioButton rb22 = new RadioButton("Portuguese");
        hb2.getChildren().add(rb22);
        rb22.setToggleGroup(group2);
        RadioButton rb23 = new RadioButton("Catalan");
        hb2.getChildren().add(rb23);
        rb23.setToggleGroup(group2);
       
        vbQuiz.getChildren().add(ques2);
        vbQuiz.getChildren().add(hb2);
        //

        RadioButton rb31 = new RadioButton("4.784");
        hb3.getChildren().add(rb31);
        rb31.setToggleGroup(group3);
        RadioButton rb32 = new RadioButton("3.689");
        hb3.getChildren().add(rb32);
        rb32.setToggleGroup(group3);
        RadioButton rb33 = new RadioButton("5.879");
        hb3.getChildren().add(rb33);
        rb33.setToggleGroup(group3);
      
        vbQuiz.getChildren().add(ques3);
        vbQuiz.getChildren().add(hb3);
        //

        RadioButton rb41 = new RadioButton("Ulster");
        hb4.getChildren().add(rb41);
        rb41.setToggleGroup(group4);
        RadioButton rb42 = new RadioButton("Munster");
        hb4.getChildren().add(rb42);
        rb42.setToggleGroup(group4);
        RadioButton rb43 = new RadioButton("Connacht");
        hb4.getChildren().add(rb43);
        rb43.setToggleGroup(group4);
        
        vbQuiz.getChildren().add(ques4);
        vbQuiz.getChildren().add(hb4);
        vbQuiz.getChildren().add(btnAnswer);
        QuizPane.setContent(vbQuiz);
        gridPane.add(QuizPane, 1, 1,2,6);
        QuizPane.setVisible(false);
        
        // Add quiz button
        Button btnQuiz = new Button("Quiz");
        btnQuiz.setStyle("-fx-background-color: #87CEFA;");
        btnQuiz.setMaxWidth(Double.MAX_VALUE);
        gridPane.add(btnQuiz, 0, 6);
        GridPane.setHalignment(btnQuiz, HPos.LEFT);
        btnQuiz.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    historyPane.setVisible(false);
                    linksPane.setVisible(false);
                    galleryPane.setVisible(false);
                    placesPane.setVisible(false);
                    videosPane.setVisible(false);
                    linksPane.setVisible(false);
                    QuizPane.setVisible(true);
                }
            }
        );
        btnAnswer.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    int correct = 0;
                    int total = 4;
                    if(rb11.isSelected() == true)
                        correct++;
                    if(rb21.isSelected() == true)
                        correct++;
                    if(rb31.isSelected() == true)
                        correct++;
                    if(rb43.isSelected() == true)
                        correct++;
                    
                    showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Result of quiz", "Score: \n"+correct+"  out of "+total); 
                }
            }
        );
    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    private Label createLabel(String text, Color color,Color bgcolor, int size) {
        
        Label l = new Label(text);
        l.setContentDisplay(ContentDisplay.TOP);
        l.setTextFill(color);
        l.setStyle("-fx-background-color:'"+bgcolor+"'");
        l.setPadding(new Insets(10,10,0,10));
        l.setMaxHeight(Double.MAX_VALUE);
 
        l.setFont(new Font(size));
        return l;
    }
     private Button createButton(String text, Color color, int size) {
       Rectangle r = new Rectangle(3 * size, 2 * size);
        r.setFill(Color.TRANSPARENT);
        r.setStroke(color);
        r.setStrokeWidth(3);
    
        Button l = new Button(text,r);
        l.setContentDisplay(ContentDisplay.TOP);
        l.setStyle("-fx-background-color: #FFFFFF;");
        l.setFont(new Font(16));
        return l;
    }
    private ImageView createImageView(final File imageFile) {
        // DEFAULT_THUMBNAIL_WIDTH is a constant you need to define
        // The last two arguments are: preserveRatio, and use smooth (slower)
        // resizing

        ImageView imageView = null;
        try {
            final Image image = new Image(new FileInputStream(imageFile), 150, 0, true,
                    true);
            imageView = new ImageView(image);
            imageView.setFitWidth(150);
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {

                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){

                        if(mouseEvent.getClickCount() == 2){
                            try {
                                BorderPane borderPane = new BorderPane();
                                ImageView imageView = new ImageView();
                                Image image = new Image(new FileInputStream(imageFile));
                                imageView.setImage(image);
                                imageView.setStyle("-fx-background-color: BLACK");
                                imageView.setFitHeight(stage.getHeight() - 10);
                                imageView.setPreserveRatio(true);
                                imageView.setSmooth(true);
                                imageView.setCache(true);
                                borderPane.setCenter(imageView);
                                borderPane.setStyle("-fx-background-color: BLACK");
                                Stage newStage = new Stage();
                                newStage.setWidth(stage.getWidth());
                                newStage.setHeight(stage.getHeight());
                                newStage.setTitle(imageFile.getName());
                                Scene scene = new Scene(borderPane,Color.BLACK);
                                newStage.setScene(scene);
                                newStage.show();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
            });
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return imageView;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

   
}

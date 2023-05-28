package control;

import javafx.scene.control.TextArea;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;
import javafx.scene.image.ImageView;

public class MainViewController implements Initializable {
	
	@FXML
    public Button circle1;
    @FXML
    public Button circle2;
    @FXML
    public Button circle3;
    @FXML
    public Button launch;
    @FXML
    public Button stop;
    @FXML
    public Button taskBtn;
    @FXML
    public Button theoryBtn;
    @FXML
    public Button newQuestion;
    @FXML
    public Button checkAnswer;
    @FXML
    public Button stopAnswer;
    @FXML
    public Button nextQuestion;
    @FXML
    public Button ready;
    @FXML
    public Button startTask;
    @FXML
    public Button ToModel;
    @FXML
    public Button exit;
    
    @FXML
    public Button backFIrstLpp;
    @FXML
    public Button backSecondLpp;
    @FXML
    public Button backThirdLpp;
    @FXML
    public Button backFourthLpp;
    @FXML
    public Button toSecondLpp;
    @FXML
    public Button toThirdLpp;
    @FXML
    public Button toFourthLpp;
    @FXML
    public Button toFifthLpp;
    
    @FXML
    public StackPane stackPane;
    @FXML
    public Pane circlePane;
    @FXML
    public Pane taskPane;
    @FXML
    public Pane answerPane;
    @FXML
    public Pane theoryPane1;
    @FXML
    public Pane theoryPane2;
    @FXML
    public Pane theoryPane3;
    @FXML
    public Pane theoryPane4;
    @FXML
    public Pane theoryPane5;
    
    @FXML
    public Label rightLabel1;
    @FXML
    public Label rightLabel2;
    @FXML
    public Label rightLabel3;
    @FXML
    public Label message;
    @FXML
    public Label message2;
    @FXML
    public TextArea taskText;
    @FXML
    public TextArea firstTask;
    @FXML
    public TextArea secondTask;
    @FXML
    public TextArea thirdTask;
    @FXML
    public TextArea fourthTask;
    @FXML
    public TextArea taskTextAnswer;
    @FXML
    public TextArea firstTaskAnswer;
    @FXML
    public TextArea secondTaskAnswer;
    @FXML
    public TextArea thirdTaskAnswer;
    @FXML
    public TextArea fourthTaskAnswer;

    @FXML
    public CheckBox checkA;
    @FXML
    public CheckBox checkB;
    @FXML
    public CheckBox checkC;
    @FXML
    public CheckBox checkD;
    @FXML
    public CheckBox checkAAnswer;
    @FXML
    public CheckBox checkBAnswer;
    @FXML
    public CheckBox checkCAnswer;
    @FXML
    public CheckBox checkDAnswer;
    
    @FXML
    public ImageView AGreen;
    @FXML
    public ImageView BGreen;
    @FXML
    public ImageView CGreen;
    @FXML
    public ImageView DGreen;
    @FXML
    public ImageView ARed;
    @FXML
    public ImageView BRed;
    @FXML
    public ImageView CRed;
    @FXML
    public ImageView DRed;
    @FXML
    public ImageView roundArrow1;
    @FXML
    public ImageView roundArrow2;
    @FXML
    public ImageView roundArrow3;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	MemoryUsage();
    	CPUusage();
    	MakeTest();
    }
    

    Pane CoordinatesPane = new Pane(); 
    ArrayList<LinkedList<Character>> listOfanswers = new ArrayList<>();
    ArrayList<String> TaskText = new ArrayList<>();
    ArrayList<String> TextA = new ArrayList<>();
    ArrayList<String> TextB = new ArrayList<>();
    ArrayList<String> TextC = new ArrayList<>();
    ArrayList<String> TextD = new ArrayList<>();
    int TaskCounter = 0;
    int ThisCounter = 0;

    private void enableModelButtons() {
    	launch.setDisable(false);
    	stop.setDisable(false);
    	circle1.setDisable(false);
    	circle2.setDisable(false);
    	circle3.setDisable(false);
    }
    
    private void disableRightLabels() {
    	rightLabel1.setVisible(false);
    	rightLabel2.setVisible(false);
    	rightLabel3.setVisible(false);
    }
    
    private void disableModelButtons() {
    	launch.setDisable(true);
    	stop.setDisable(true);
    	circle1.setDisable(true);
    	circle2.setDisable(true);
    	circle3.setDisable(true);
    }
    
    private void unCheck() {
    	checkAAnswer.setSelected(false);
    	checkBAnswer.setSelected(false);
    	checkCAnswer.setSelected(false);
    	checkDAnswer.setSelected(false);
    }
    
    private void resetMarksAnswers() {
    	AGreen.setVisible(false);
    	BGreen.setVisible(false);
    	CGreen.setVisible(false);
    	DGreen.setVisible(false);
    	ARed.setVisible(false);
    	BRed.setVisible(false);
    	CRed.setVisible(false);
    	DRed.setVisible(false);
    }
    
    private void resetTask() {
    	taskText.clear();
    	firstTask.clear();
    	secondTask.clear();
    	thirdTask.clear();
    	fourthTask.clear();
    	checkA.setSelected(false);
    	checkB.setSelected(false);
    	checkC.setSelected(false);
    	checkD.setSelected(false);
    	startTask.setDisable(true);
    	newQuestion.setDisable(true);
    	ready.setDisable(false);
    }
     
    private void resetAnswer() {
    	resetMarksAnswers();
    	unCheck();
    	taskTextAnswer.clear();
    	firstTaskAnswer.clear();
    	secondTaskAnswer.clear();
    	thirdTaskAnswer.clear();
    	fourthTaskAnswer.clear();
    	stopAnswer.setVisible(false);
    	nextQuestion.setDisable(true);
    	checkAnswer.setDisable(false);
    }
    
    private void startAnswerAction() {
    	theoryBtn.setDisable(true);
    	ToModel.setDisable(true);
    	taskBtn.setDisable(true);
    }
    
    private void endAnswerAction() {
    	message.setVisible(false);
    	ToModel.setDisable(false);
    	theoryBtn.setDisable(false);
    	taskBtn.setDisable(false);
    }
    
    private void ArrowSphere2() {
    	roundArrow1.setVisible(true);
    	roundArrow2.setVisible(true);
    }
    
    private void ArrowSphere3() {
    	roundArrow1.setVisible(true);
    	roundArrow2.setVisible(true);
    	roundArrow3.setVisible(true);
    }
    
    private void resetArrows() {
    	roundArrow1.setVisible(false);
    	roundArrow2.setVisible(false);
    	roundArrow3.setVisible(false);
    }
    
    
    @FXML
    private void exitBtnAction(ActionEvent event) {
    	PrintAverageUsedRAM();
    	PrintAverageCPUusage();
    	Platform.exit();
    }
    
    @FXML
    private void taskBtnAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	disableRightLabels();
        disableModelButtons();
    	stackPane.getChildren().add(this.taskPane);
    }
   
    @FXML
    private void theoryBtnAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	disableRightLabels();
        disableModelButtons();
    	stackPane.getChildren().add(this.theoryPane1);
    }
    
    @FXML
    private void toModelAction(ActionEvent event) {
    	CoordinatesPane.getChildren().clear();
        stackPane.getChildren().clear();
        stackPane.getChildren().add(this.circlePane);
        enableModelButtons();
        resetArrows();
        rightLabel1.setVisible(false);
    	rightLabel2.setVisible(false);
    	rightLabel3.setVisible(true);
    }
    
    
    public Group Sphere1() {
        
        Group root = new Group();
           
        Random random =  new Random();
        Sphere sphere1 = new Sphere(20);

        sphere1 = new Sphere(20);
        
        Color randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere1.setMaterial(new PhongMaterial(randomColor));
        root.getChildren().add(sphere1);
        
    	
        Path path = new Path();
       
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 100));
        
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 100));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
        
        
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(650, 300));
        
        path.getElements().add(new javafx.scene.shape.MoveTo(650, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
        
        
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(195, 450));
        
        path.getElements().add(new javafx.scene.shape.MoveTo(195, 450));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
        
        
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(10));
        pathTransition.setPath(path);
        pathTransition.setNode(sphere1);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(true);

        pathTransition.play();
        
        return root;
    }
    
    @FXML
    private void circle1BtnAction(ActionEvent event) {
    	CoordinatesPane.getChildren().clear();
        stackPane.getChildren().clear();
        stackPane.getChildren().add(this.circlePane);
        resetArrows();
        CoordinatesPane.setStyle("-fx-background-color:transparent;");
        CoordinatesPane.getChildren().add(Sphere1());
        rightLabel1.setVisible(true);
        rightLabel1.setText("Brīvības Pakāpe: i = 3");
        rightLabel2.setVisible(true);
        rightLabel2.setText("Vien Atomu");
    }

    public Group Sphere2() {
    	
        Group root = new Group();
        
        Group group = new Group();
        Random random =  new Random();
        
        Sphere sphere1 = new Sphere(20); 
        sphere1.setTranslateX(350);
        sphere1.setTranslateY(250);

        Color randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere1.setMaterial(new PhongMaterial(randomColor));
        
        Sphere sphere2 = new Sphere(20);
        sphere2.setTranslateX(450);
        sphere2.setTranslateY(350);

        randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere2.setMaterial(new PhongMaterial(randomColor));
        
        Line innerLine  = new Line(sphere1.getTranslateX(),sphere1.getTranslateY(),sphere2.getTranslateX(),sphere2.getTranslateY());
        innerLine.setStroke(Color.WHITESMOKE);
        
        group.getChildren().addAll(sphere1,sphere2,innerLine);
        root.getChildren().add(group);
        
        Path path = new Path();
       
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 100));
         
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 100));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
         
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(650, 300));
         
        path.getElements().add(new javafx.scene.shape.MoveTo(650, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
         
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(195, 450));
         
        path.getElements().add(new javafx.scene.shape.MoveTo(195, 450));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
        
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(8.5), group);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.play();
        
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(12));
        pathTransition.setPath(path);
        pathTransition.setNode(group);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
        
        pathTransition.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            Duration currentTime = newValue;
            double progress = currentTime.toMillis() / pathTransition.getDuration().toMillis();
            boolean movingOnX = progress >= 0.33 && progress <= 0.60;

            if (movingOnX) {
                rotateTransition.pause();
            } else {
                rotateTransition.play();
            }
        });
        
        return root;
    }
    
    @FXML
    private void circle2BtnAction(ActionEvent event) {
    	CoordinatesPane.getChildren().clear();
        stackPane.getChildren().clear();
        stackPane.getChildren().add(this.circlePane);
        resetArrows();
        ArrowSphere2();    
        CoordinatesPane.setStyle("-fx-background-color:transparent;");
        CoordinatesPane.getChildren().add(Sphere2());
        rightLabel1.setVisible(true);
        rightLabel1.setText("Brīvības Pakāpe: i = 5");
        rightLabel2.setVisible(true);
        rightLabel2.setText("Div Atomu");
    }

    public Group Sphere3() {
    	
        Group root = new Group();

        Group group = new Group();
        Random random = new Random();

        Sphere sphere1 = new Sphere(20);
        sphere1.setTranslateX(350);
        sphere1.setTranslateY(250);
        Color randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere1.setMaterial(new PhongMaterial(randomColor));

        Sphere sphere2 = new Sphere(20);
        sphere2.setTranslateX(400);
        sphere2.setTranslateY(350);
        randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere2.setMaterial(new PhongMaterial(randomColor));

        Sphere sphere3 = new Sphere(20);
        sphere3.setTranslateX(300);
        sphere3.setTranslateY(350);
        randomColor = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        sphere3.setMaterial(new PhongMaterial(randomColor));

        Line line1 = new Line(sphere1.getTranslateX(), sphere1.getTranslateY(), sphere2.getTranslateX(), sphere2.getTranslateY());
        line1.setStroke(Color.WHITESMOKE);

        Line line2 = new Line(sphere2.getTranslateX(), sphere2.getTranslateY(), sphere3.getTranslateX(), sphere3.getTranslateY());
        line2.setStroke(Color.WHITESMOKE);

        Line line3 = new Line(sphere3.getTranslateX(), sphere3.getTranslateY(), sphere1.getTranslateX(), sphere1.getTranslateY());
        line3.setStroke(Color.WHITESMOKE);

        
        double line1DiffX = line1.getStartX() - line1.getEndX();
        double line1DiffY = line1.getStartY() - line1.getEndY();
        double line2DiffX = line2.getStartX() - line2.getEndX();
        double line2DiffY = line2.getStartY() - line2.getEndY();
        double line1CoordinateDiff = (Math.pow(line1.getStartX(), 2) - Math.pow(line1.getEndX(), 2)) + (Math.pow(line1.getStartY(), 2) - Math.pow(line1.getEndY(), 2));
        double line2CoordinateDiff = (Math.pow(line2.getStartX(), 2) - Math.pow(line2.getEndX(), 2)) + (Math.pow(line2.getStartY(), 2) - Math.pow(line2.getEndY(), 2));

        double centerX = (line2DiffY * line1CoordinateDiff - line1DiffY * line2CoordinateDiff) / (2 * line1DiffX * line2DiffY - 2 * line1DiffY * line2DiffX);
        double centerY = (line1DiffX * line2CoordinateDiff - line2DiffX * line1CoordinateDiff) / (2 * line1DiffX * line2DiffY - 2 * line1DiffY * line2DiffX);
        double radius = Math.sqrt(Math.pow(centerX - sphere1.getTranslateX(), 2) + Math.pow(centerY - sphere1.getTranslateY(), 2));

        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.TRANSPARENT);

        group.getChildren().addAll(sphere1, sphere2, sphere3, line1, line2, line3, circle);
        root.getChildren().add(group);

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(10), group);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.play();
        
        group.setRotate(45);

        
        Path path = new Path();

        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 100));
         
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 100));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
         
         
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(650, 300));
         
        path.getElements().add(new javafx.scene.shape.MoveTo(650, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));
         
         
        path.getElements().add(new javafx.scene.shape.MoveTo(400, 300));
        path.getElements().add(new javafx.scene.shape.LineTo(195, 450));
         
        path.getElements().add(new javafx.scene.shape.MoveTo(195, 450));
        path.getElements().add(new javafx.scene.shape.LineTo(400, 300));


        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(10));
        pathTransition.setPath(path);
        pathTransition.setNode(group);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(true);

        pathTransition.play();

        return root;
    }
    
    @FXML
    private void circle3BtnAction(ActionEvent event) {
    	CoordinatesPane.getChildren().clear();
        stackPane.getChildren().clear();
        stackPane.getChildren().add(this.circlePane);
        resetArrows();
        ArrowSphere3();
        CoordinatesPane.setStyle("-fx-background-color:transparent;");
        CoordinatesPane.getChildren().add(Sphere3());
        rightLabel1.setVisible(true);
        rightLabel1.setText("Brīvības Pakāpe: i = 6");
        rightLabel2.setVisible(true);
        rightLabel2.setText("Trīs Atomu");
    }

    @FXML
    private void launchBtnAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.circlePane);
    	stackPane.getChildren().add(CoordinatesPane);
    }
    
    @FXML
    private void stopBtnAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.circlePane);
    }
    
    

    
    @FXML
    private void readyAction(ActionEvent event) {
    	String TaskTextField = taskText.getText();
    	if(TaskTextField.isEmpty()) {
    		message.setVisible(true);
    		message.setText("Definējiet uzdevuma noteikumu");
    		return;
    	}
    	String FirstTask = firstTask.getText();
    	String SecondTask = secondTask.getText();
    	String ThirdTask = thirdTask.getText();
    	String FourthTask = fourthTask.getText();
    	if(FirstTask.isEmpty() || SecondTask.isEmpty() || ThirdTask.isEmpty() || FourthTask.isEmpty()) {
    		message.setVisible(true);
    		message.setText("Ne visas atbildes ir definētas");
    		return;
    	}
    	if(!checkA.isSelected() && !checkB.isSelected() && !checkC.isSelected() && !checkD.isSelected()) {
    		message.setVisible(true);
    		message.setText("Definējiet kaut vienu pareizo atbildi");
    		return;
    	}
    	LinkedList<Character> answers = new LinkedList<>();
    	if(checkA.isSelected()) {
    		answers.add('A');
    	}
    	if(checkB.isSelected()) {
    		answers.add('B');
    	}
    	if(checkC.isSelected()) {
    		answers.add('C');
    	}
    	if(checkD.isSelected()) {
    		answers.add('D');
    	}
    	listOfanswers.add(answers);
    	TaskText.add(taskText.getText());
    	TextA.add(firstTask.getText());
    	TextB.add(secondTask.getText());
    	TextC.add(thirdTask.getText());
    	TextD.add(fourthTask.getText());
    	TaskCounter++;
    	
    	startTask.setDisable(false);
    	newQuestion.setDisable(false);
    	ready.setDisable(true);
    	message.setVisible(false);
    }
  
    @FXML
    private void newQuestionAction(ActionEvent event) {
    	resetTask();
    	message2.setText("Jautājumu skaits: " + TaskCounter);
    	message2.setVisible(true);
    }
    
    @FXML
    private void startTaskAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.answerPane);
    	startAnswerAction();
    	taskTextAnswer.setText(TaskText.get(ThisCounter));
    	firstTaskAnswer.setText(TextA.get(ThisCounter));
    	secondTaskAnswer.setText(TextB.get(ThisCounter));
    	thirdTaskAnswer.setText(TextC.get(ThisCounter));
    	fourthTaskAnswer.setText(TextD.get(ThisCounter));
    }
    
    
    
    
    @FXML
    private void checkAnswerAction(ActionEvent event) { 
    	if(checkAAnswer.isSelected()) {
    		if(listOfanswers.get(ThisCounter).indexOf('A') != -1) {
    			AGreen.setVisible(true);
    		}
    		if(listOfanswers.get(ThisCounter).indexOf('A') == -1) {
    			ARed.setVisible(true);
    		}
    	} else {
    		if(listOfanswers.get(ThisCounter).indexOf('A') != -1) {
    			ARed.setVisible(true);
    		}
    	}
    	
    	if(checkBAnswer.isSelected()) {
    		if(listOfanswers.get(ThisCounter).indexOf('B') != -1) {
    			BGreen.setVisible(true);
    		}
    		if(listOfanswers.get(ThisCounter).indexOf('B') == -1) {
    			BRed.setVisible(true);
    		}
    	} else {
    		if(listOfanswers.get(ThisCounter).indexOf('B') != -1) {
    			BRed.setVisible(true);
    		}
    	}
    	
    	if(checkCAnswer.isSelected()) {
    		if(listOfanswers.get(ThisCounter).indexOf('C') != -1) {
    			CGreen.setVisible(true);
    		}
    		if(listOfanswers.get(ThisCounter).indexOf('C') == -1) {
    			CRed.setVisible(true);
    		}
    	} else {
    		if(listOfanswers.get(ThisCounter).indexOf('C') != -1) {
    			CRed.setVisible(true);
    		}
    	}
    	
    	if(checkDAnswer.isSelected()) {
    		if(listOfanswers.get(ThisCounter).indexOf('D') != -1) {
    			DGreen.setVisible(true);
    		}
    		if(listOfanswers.get(ThisCounter).indexOf('D') == -1) {
    			DRed.setVisible(true);
    		}
    	} else {
    		if(listOfanswers.get(ThisCounter).indexOf('D') != -1) {
    			DRed.setVisible(true);
    		}
    	}
    	
    	if(ThisCounter == TaskCounter-1) {
    		stopAnswer.setVisible(true);
    		nextQuestion.setDisable(true);
        	checkAnswer.setDisable(true);
    		return;
    	}
    	nextQuestion.setDisable(false);
    	checkAnswer.setDisable(true);
    }
    
    @FXML
    private void nextQuestionAction(ActionEvent event) {
    	nextQuestion.setDisable(true);
    	checkAnswer.setDisable(false);
    	unCheck();
    	resetMarksAnswers();
    	ThisCounter++;
    	taskTextAnswer.setText(TaskText.get(ThisCounter));
    	firstTaskAnswer.setText(TextA.get(ThisCounter));
    	secondTaskAnswer.setText(TextB.get(ThisCounter));
    	thirdTaskAnswer.setText(TextC.get(ThisCounter));
    	fourthTaskAnswer.setText(TextD.get(ThisCounter));
    }
    
    @FXML
    private void stopAnswerAction(ActionEvent event) { 
    	toModelAction(event);
    	TaskCounter = 0;
    	ThisCounter = 0;
    	listOfanswers.clear();
    	TaskText.clear();
    	TextA.clear();
    	TextB.clear();
    	TextC.clear();
    	TextD.clear();
    	message2.setVisible(false);
    	resetTask();
    	resetAnswer();
    	endAnswerAction();
    }
    
    
    
    
    @FXML
    private void backFirstLppAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.theoryPane1);
    }
    
    @FXML
    private void backSecondLppAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.theoryPane2);
    }
    
    @FXML
    private void backThirdLppAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.theoryPane3);
    }
    
    @FXML
    private void backFourthLppAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.theoryPane4);
    }
    
    
    
    
    @FXML
    private void toSecondLppAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.theoryPane2);
    }
    
    @FXML
    private void toThirdLppAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.theoryPane3);
    }
    
    @FXML
    private void toFourthLppAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.theoryPane4);
    }
    
    @FXML
    private void toFifthLppAction(ActionEvent event) {
    	stackPane.getChildren().clear();
    	stackPane.getChildren().add(this.theoryPane5);
    }
    
    
    
    int RAMcount = 0;
    long MemoryUsed = 0;
    long AverageMemoryUsed = 0;
    long MaxMemory = 0;
    long CurrentMemory = 0;
    private void MemoryUsage() {
    	 Runnable memoryMonitor = () -> {
             MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
             while (true) {
            	 try {
                 MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
                 RAMcount++;
                 CurrentMemory = memoryUsage.getUsed();
                 MemoryUsed = MemoryUsed + CurrentMemory;
                 if (CurrentMemory > MaxMemory) {
                     MaxMemory = CurrentMemory;
                 }
                 Thread.sleep(1000);
            	 } catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
                    break;
				}
             }
         };
         Thread memoryMonitorThread = new Thread(memoryMonitor);
         memoryMonitorThread.setDaemon(true);
         memoryMonitorThread.start();
    }
    
    private void PrintAverageUsedRAM() {
    	AverageMemoryUsed = MemoryUsed/RAMcount;
    	System.out.println("Average RAM usage: " + AverageMemoryUsed);
    	System.out.println("Max RAM usage: " + MaxMemory);
    }
    
    
    int CPUcount = 0;
    double CPUusage = 0.0;
    double AverageCPUusage = 0.0;
    private void CPUusage() {
        Runnable cpuMonitoringTask = () -> {
            while (true) {
            	try {
                OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
                com.sun.management.OperatingSystemMXBean sunOsBean = (com.sun.management.OperatingSystemMXBean) osBean;
                double CpuLoad = sunOsBean.getProcessCpuLoad() * 100;
                CPUcount++;
                CPUusage = CPUusage + CpuLoad;
                Thread.sleep(1000);
                } catch (InterruptedException e) {
                	e.printStackTrace();
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };
        Thread cpuMonitoringThread = new Thread(cpuMonitoringTask);
        cpuMonitoringThread.setDaemon(true);
        cpuMonitoringThread.start();
    }
    
    private void PrintAverageCPUusage() {
    	AverageCPUusage = CPUusage/CPUcount;
    	System.out.println("Average CPU usage: " + AverageCPUusage);
    }
    
    private void MakeTest() {
    	
    	Timeline timeline = new Timeline(

                new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	ToModel.fire();
                    	circle1.fire();
                    	launch.fire();
                    }
                }),

                new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	circle2.fire();
                    	launch.fire();
                    }
                }),

                new KeyFrame(Duration.seconds(20), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	circle3.fire();
                    	launch.fire();
                    }
                }),
                
                new KeyFrame(Duration.seconds(30), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	theoryBtn.fire();
                    }
                }),
                
                new KeyFrame(Duration.seconds(32), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	toSecondLpp.fire();
                    }
                }),
                
                new KeyFrame(Duration.seconds(34), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	toThirdLpp.fire();
                    }
                }),
                
                new KeyFrame(Duration.seconds(36), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	toFourthLpp.fire();
                    }
                }),
                
                new KeyFrame(Duration.seconds(38), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	toFifthLpp.fire();
                    }
                }),
                
                new KeyFrame(Duration.seconds(40), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	taskBtn.fire();
                    	taskText.setText("test");
                    	firstTask.setText("test");
                    	secondTask.setText("test");
                    	thirdTask.setText("test");
                    	fourthTask.setText("test");
                    	checkA.setSelected(true);
                    	checkB.setSelected(true);
                    }
                }),
                
                new KeyFrame(Duration.seconds(42), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	ready.fire();
                    	startTask.fire();
                    }
                }),
                
                new KeyFrame(Duration.seconds(44), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	checkAAnswer.setSelected(true);
                    	checkCAnswer.setSelected(true);
                    	checkAnswer.fire();
                    }
                }),
                
                new KeyFrame(Duration.seconds(46), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	stopAnswer.fire();
                    }
                }),
                
                new KeyFrame(Duration.seconds(48), new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                    	exit.fire();
                    }
                })
            );
    	
    	timeline.play();
    }
    
}

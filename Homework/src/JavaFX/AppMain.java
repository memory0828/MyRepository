package JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {
    public static void main(String[] args){
    	launch(args); //실행
    }


	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.show();
		primaryStage.setTitle("테스트");
		
	}
    
}
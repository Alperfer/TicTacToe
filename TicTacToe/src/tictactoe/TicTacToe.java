/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import static javafx.print.PrintColor.COLOR;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author alper
 */


public class TicTacToe extends Application {
    
    int turn = 0 ;
    Tile[][] tileTrack = new Tile[3][3] ;
    String player = "";
    @Override
    public void start(Stage primaryStage) {
        
        FlowPane mainP = new FlowPane() ;
        Scene scene = new Scene(mainP,600, 600);
        
        setup(mainP) ; //Board setup
        
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private class Tile extends StackPane
    {
        public Text text = new Text("") ;
        
        public Tile()
        {
            Rectangle rec = new Rectangle(203,203) ;
            rec.setStroke(Color.BLACK);
            rec.setFill(Color.WHITE);
            text.setFont(Font.font(100)) ;
            setAlignment(Pos.CENTER) ;
            getChildren().addAll(rec,text) ;
            
            setOnMouseClicked(e ->{
                if(turn % 2 == 0 && this.text.getText().equals(""))
                {
                    setX() ;
                    checkWin();
                }
                else if((turn % 2 == 1 && this.text.getText().equals("")))
                {
                    setO() ;
                    checkWin();
                }
            }) ;
 
        }
        private void setX()
        {
            this.text.setText("X");
            turn++ ;
        }
        private void setO()
        {
            this.text.setText("O");
            turn++ ;
        }
        private Text getText()
        {
            return this.text ;
        }
        
    }
    
    private class Move 
    { 
        int row, col; 
    }; 
    
    
    public void setup(FlowPane fp)
    {
        for(int i=0 ; i<3 ; i++)
        {
            for(int j=0 ; j<3 ; j++)
            {
                Tile t = new Tile() ;
                fp.getChildren().add(t) ;
                tileTrack[i][j] = t ;
            }
        }
    }
     
    public void checkWin()
    {
        boolean draw = true ;
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Game Over");
        for(int i=0 ;i<tileTrack.length ;i++)
        {
            if((tileTrack[i][0].text.getText().equals("") == false))
            {
                if((tileTrack[i][0].text.getText().equals(tileTrack[i][1].text.getText())) && (tileTrack[i][0].text.getText().equals(tileTrack[i][2].text.getText())))
                {
                    
                    if(tileTrack[i][0].text.getText().equals("X"))
                        alert.setContentText("Player X wins!") ;
                    else
                        alert.setContentText("Player O wins!") ;
                    alert.showAndWait();
                    end();
                }
            }
        
            if((tileTrack[0][i].text.getText().equals("")== false))
            {
                if(tileTrack[0][i].text.getText().equals(tileTrack[1][i].text.getText()) && tileTrack[0][i].text.getText().equals(tileTrack[2][i].text.getText()))
                {
                    if(tileTrack[0][i].text.getText().equals("X"))
                        alert.setContentText("Player X wins!") ;
                    else
                        alert.setContentText("Player O wins!") ;
                    alert.showAndWait();
                    end();
                }
            }
            if(tileTrack[0][0].text.getText().equals("") == false)
            {
                if(tileTrack[0][0].text.getText().equals(tileTrack[1][1].text.getText()) && tileTrack[0][0].text.getText().equals(tileTrack[2][2].text.getText()))
                {
                    if(tileTrack[0][0].text.getText().equals("X"))
                        alert.setContentText("Player X wins!") ;
                    else
                        alert.setContentText("Player O wins!") ;
                    alert.showAndWait();
                    end();
                }
            }
            if(tileTrack[0][2].text.getText().equals("")== false)
            {
                if((tileTrack[0][2].text.getText().equals(tileTrack[1][1].text.getText()) && tileTrack[0][2].text.getText().equals(tileTrack[2][0].text.getText())))
                {
                    if(tileTrack[0][2].text.getText().equals("X"))
                        alert.setContentText("Player X wins!") ;
                    else
                        alert.setContentText("Player O wins!") ;
                    alert.showAndWait();
                    end();
                }
            }
        }
       
       for(int i=0 ;i<tileTrack.length ;i++)
        {
            for(int j=0 ; j<tileTrack.length; j++)
            {
                    if(tileTrack[i][j].text.getText().equals(""))
                        draw = false ;
            }
        }
                
        if(draw)
        {
            alert.setContentText("It's a draw!") ;
            alert.showAndWait();
            end();
        }
        
    }
    
    public void end()
    {
        for(int i=0; i<tileTrack.length ;i++)
        {
            for(int j=0 ; j<tileTrack.length ;j++)
            {
                tileTrack[i][j].text.setText("");
                turn = 0 ;
            }
        }
    }
    //Will implement an Ai in the future
    public void ai()
    {
        for(int i=0 ; i<tileTrack.length; i++)
        {
            for(int j=0 ; j<tileTrack.length; j++)
            {
            
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}


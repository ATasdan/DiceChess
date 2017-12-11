package dicechess;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dice extends ImageView{

    protected int randomNumber;
    protected int color = 0;
    
    Dice(int color){
        this.color = color;
    }
    
    public int roll() {
        randomNumber = (int)(Math.random()* 6 + 1);
        if(color == 0){
            switch(randomNumber){
                case 1:
                    setImage(new Image(getClass().getResource("Images/wp.png").toExternalForm()));
                    break;
                case 2:
                    setImage(new Image(getClass().getResource("Images/wn.png").toExternalForm()));
                    break;
                case 3:
                    setImage(new Image(getClass().getResource("Images/wb.png").toExternalForm()));
                    break;
                case 4:
                    setImage(new Image(getClass().getResource("Images/wr.png").toExternalForm()));
                    break;
                case 5:
                    setImage(new Image(getClass().getResource("Images/wq.png").toExternalForm()));
                    break;
                case 6:
                    setImage(new Image(getClass().getResource("Images/wk.png").toExternalForm()));
                    break;
            }
        }
        else if(color == 1)
            switch(randomNumber){
                case 1:
                    setImage(new Image(getClass().getResource("Images/bp.png").toExternalForm()));
                    break;
                case 2:
                    setImage(new Image(getClass().getResource("Images/bn.png").toExternalForm()));
                    break;
                case 3:
                    setImage(new Image(getClass().getResource("Images/bb.png").toExternalForm()));
                    break;
                case 4:
                    setImage(new Image(getClass().getResource("Images/br.png").toExternalForm()));
                    break;
                case 5:
                    setImage(new Image(getClass().getResource("Images/bq.png").toExternalForm()));
                    break;
                case 6:
                    setImage(new Image(getClass().getResource("Images/bk.png").toExternalForm()));
                    break;
            }
        return randomNumber;
    }
    
}

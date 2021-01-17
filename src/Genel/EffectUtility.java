package Genel;
/**
 *
 * @author İsmail BOZKURT
 */

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EffectUtility {

    public static void makeDraggable(final Stage stage, final Node byNode) {
        final Delta dragDelta = new Delta();
        byNode.setOnMousePressed((MouseEvent event) -> {
            dragDelta.x = stage.getX() - event.getSceneX();
            dragDelta.y = stage.getY() - event.getSceneY();
            byNode.setCursor(Cursor.MOVE);
        });
        byNode.setOnMouseReleased((MouseEvent event) -> {
            byNode.setCursor(Cursor.HAND);
        });
        byNode.setOnMouseDragged((MouseEvent mouseEvent) -> {
            stage.setX(mouseEvent.getScreenX() + dragDelta.x);
            stage.setY(mouseEvent.getScreenY() + dragDelta.y);
        });
        byNode.setOnMouseEntered((MouseEvent mouseEvent) -> {
            if (!mouseEvent.isPrimaryButtonDown()) {
                byNode.setCursor(Cursor.HAND);
            }
        });
        byNode.setOnMouseExited((MouseEvent mouseEvent) -> {
            if (!mouseEvent.isPrimaryButtonDown()) {
                byNode.setCursor(Cursor.DEFAULT);
            }
        });
    }

    public static class Delta {

        double x, y;
    }

}

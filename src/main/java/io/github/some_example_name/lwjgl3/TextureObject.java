package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input.Keys;

//TextureObject class
class TextureObject extends Entity {
	private Texture texture;
	private boolean isAIControlled; // True = Drop (AI), False = Bucket (Player)

 public TextureObject(String texturePath, float x, float y, float speed, boolean isAIControlled) {
     super(x, y, speed, "");
     this.texture = new Texture(Gdx.files.internal(texturePath)); // Load texture
     this.isAIControlled = isAIControlled;
 }

 @Override
 public void draw(SpriteBatch batch) {
     batch.draw(texture, getX(), getY());
 }
 
 @Override
 public void movement() {
     if (isAIControlled) {
         moveAsDrop();
     } else {
         moveAsBucket();
     }
 }
 

 public void moveAsBucket() {
     if (Gdx.input.isKeyPressed(Keys.LEFT)) {
	        setX(getX() - getSpeed() * Gdx.graphics.getDeltaTime());
	    }
	    if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
	        setX(getX() + getSpeed() * Gdx.graphics.getDeltaTime());
	    }
	    
 }
	    
 private void moveAsDrop() {
     setY(getY() - getSpeed());

     // Reset when off-screen
     if (getY() + 64 < 0) {
         setY(400);
         setSpeed(getSpeed() + 2);
         if (getSpeed() > 10) {
             setSpeed(10);
         }
     }
    
 }
 
 public void update() {
     System.out.println("In texture object at " + x + "," + y + " position.");
 }
 
}

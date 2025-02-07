package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

//Entity class (Parent)
public abstract class Entity implements iMovable {
	protected float x, y;
	protected float speed;
	protected String color;
	protected ShapeRenderer shapeRenderer;

 // Default Constructor
 public Entity() {
     this.x = 0;
     this.y = 0;
     this.speed = 0;
     this.color = "";
     this.shapeRenderer = new ShapeRenderer();
 }

 // Parameterized Constructor
 public Entity(float x, float y, float speed, String color) {
     this.x = x;
     this.y = y;
     this.speed = speed;
     this.color = color;
     this.shapeRenderer = new ShapeRenderer();
 }

 // Getters and Setters
 public float getX() {
     return x;
 }

 public void setX(float x) {
     this.x = x;
 }

 public float getY() {
     return y;
 }

 public void setY(float y) {
     this.y = y;
 }

 public float getSpeed() {
     return speed;
 }

 public void setSpeed(float speed) {
     this.speed = speed;
 }

 public String getColor() {
     return color;
 }

 public void setColor(String color) {
     this.color = color;
 }

//Abstract draw method to be implemented by subclasses
 public abstract void draw(SpriteBatch batch);
 
//Abstract update method to display entity information
 public abstract void update();

//Implement movement method from iMovable (subclasses must override)
 @Override
 public abstract void movement();

 public void dispose() {
     shapeRenderer.dispose();
 }
}

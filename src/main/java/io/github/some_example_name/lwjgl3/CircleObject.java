package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Input.Keys;

//CircleObject class
class CircleObject extends Entity {
	private float radius;

 public CircleObject(float x, float y, float radius, float speed, String color) {
     super(x, y, speed, color);
     this.radius = radius;
 }

 public float getRadius() {
     return radius;
 }

 public void setRadius(float radius) {
     this.radius = radius;
 }

 @Override
 public void draw(SpriteBatch batch) {
     shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
     shapeRenderer.setColor(1, 0, 0, 1); // Example: hardcoding red color
     shapeRenderer.circle(x, y, radius);
     shapeRenderer.end();
 }

 @Override
 public void movement() {
     if (Gdx.input.isKeyPressed(Keys.UP)) {
         setY(getY() + getSpeed() * Gdx.graphics.getDeltaTime());
     }
     if (Gdx.input.isKeyPressed(Keys.DOWN)) {
         setY(getY() - getSpeed() * Gdx.graphics.getDeltaTime());
     }
 }
 
 @Override
 public void update() {
     System.out.println("In circle of radius " + radius + " at " + x + "," + y + " position.");
 }
 
}

package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Input.Keys;

//TriangleObject class
class TriangleObject extends Entity {
	private float base, height;

 public TriangleObject(float x, float y, float base, float height, float speed, String color) {
     super(x, y, speed, color);
     this.base = base;
     this.height = height;
 }

 public float getBase() {
     return base;
 }

 public void setBase(float base) {
     this.base = base;
 }

 public float getHeight() {
     return height;
 }

 public void setHeight(float height) {
     this.height = height;
 }

 @Override
 public void draw(SpriteBatch batch) {
     shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
     shapeRenderer.setColor(0, 0, 1, 1); // Example: hardcoding blue color
     shapeRenderer.triangle(x, y, x - base / 2, y - height, x + base / 2, y - height);
     shapeRenderer.end();
 }

 @Override
 public void movement() {
     if (Gdx.input.isKeyPressed(Keys.D)) {
         setX(getX() + getSpeed() * Gdx.graphics.getDeltaTime());
     }
     if (Gdx.input.isKeyPressed(Keys.A)) {
         setX(getX() - getSpeed() * Gdx.graphics.getDeltaTime());
     }
 }
 
 @Override
 public void update() {
     System.out.println("In triangle of base " + base + " and height " + height + " at " + x + "," + y + " position.");
 }
 
}

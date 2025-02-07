package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.MathUtils;

public class GameMaster extends ApplicationAdapter{

    private final int NUM_DROPS = 10;
    private EntityManager entityManager;
    private SpriteBatch batch;

    @Override
    public void create() {
    	
    	batch = new SpriteBatch();
    	entityManager = new EntityManager();

        // Create Bucket Object
        TextureObject bucket = new TextureObject("bucket.png", 275, 25, 200, false); // Bucket starts at x=275, y=25, speed=0
        entityManager.addEntity(bucket);

        // Create an array of number of drops
        for (int i = 0; i < NUM_DROPS; i++) {
            // Random starting x position between 0 and screen width (assuming 800 for example)
            float randomX = MathUtils.random(0, 800 - 64); // Assuming drop width is 64 pixels
            // Starting y position off the top of the screen
            float startY = MathUtils.random(400, 800);
            // Initialize each drop with a random starting position
            TextureObject droplets = new TextureObject("droplet.png", randomX, startY, 2, true);
            entityManager.addEntity(droplets);

        }

        // Create a Circle Object. Circle starts at x=400, y=300, radius=50, speed=200, color=red
        CircleObject circle = new CircleObject(400, 300, 50, 200, "red"); 
        
        // Create a Triangle Object. Triangle starts at x=200, y=200, width=100, height=100, speed=200, color=blue
        TriangleObject triangle = new TriangleObject(200, 200, 100, 100, 200, "blue");
        
        entityManager.addEntity(circle);
        entityManager.addEntity(triangle);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.6f, 0.4f, 0.8f, 1);

        batch.begin();
        
        entityManager.updateAndRender(batch);
        
        batch.end();
        
    }

    @Override
    public void dispose() {
        batch.dispose();
        entityManager.dispose();
        }
}

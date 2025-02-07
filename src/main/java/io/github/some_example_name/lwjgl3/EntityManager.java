package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {
	private List<Entity> entityList;
	
	public EntityManager() {
        entityList = new ArrayList<>();
    }
	
	// Add an entity to the list
    public void addEntity(Entity entity) {
        entityList.add(entity);
    }
    
    // Calls draw and movement methods for all entities
    public void updateAndRender(SpriteBatch batch) {
        for (Entity entity : entityList) {
            entity.movement(); // Handle movement
            entity.draw(batch); // Render entity
            entity.update(); // Print info to console
        }
    }
    
    // Dispose of all entities
    public void dispose() {
        for (Entity entity : entityList) {
            entity.dispose();
        }
    }
//hello darren here

}

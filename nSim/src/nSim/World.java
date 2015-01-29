package nSim;

import java.util.ArrayList;

public class World {
ArrayList<PhysicsObject> objects;
public World() {
	// TODO Auto-generated constructor stub
	this.objects=new ArrayList<PhysicsObject>();
}
public World(PhysicsObject... physicsObjects) {
	// TODO Auto-generated constructor stub
	this.objects=new ArrayList<PhysicsObject>();
	for (int s = 0; s < physicsObjects.length; s++) {
		objects.add(physicsObjects[s]);
		physicsObjects[s].world=this;
	}
	
}
public void update(double dt){
	for (int i = 0; i < objects.size(); i++) {
		objects.get(i).update( dt);
		//System.out.println(objects.get(i).mass);
	}
}

}
